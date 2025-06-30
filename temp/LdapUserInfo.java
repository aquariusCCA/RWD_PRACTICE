import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import java.util.Hashtable;

public class LdapUserInfo {
    public static void main(String[] args) {
        // 1. 準備連線環境變數（請確認此 URL 已含正確的根 DN）
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        // 只留 root DC，之後以空字串作為 searchBase
        env.put(Context.PROVIDER_URL, "ldap://10.253.1.99:389/DC=entiebank,DC=com,DC=tw");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "10192@entiebank.com.tw");
        env.put(Context.SECURITY_CREDENTIALS, "Lins860210");

        DirContext ctx = null;
        try {
            // 2. 建立連線
            ctx = new InitialDirContext(env);
            System.out.println("LDAP 連線成功！");

            // 3. 設定搜尋條件與控制
            // 3.1 空字串代表「從 PROVIDER_URL 指定的 DN 之後全樹搜尋」
            String searchBase = "";  
            // 3.2 搜尋過濾條件：依 userPrincipalName
            String searchFilter = "(userPrincipalName=10192@entiebank.com.tw)";

            SearchControls sc = new SearchControls();
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
            // 回傳所有屬性；若只要特定屬性，可改為 new String[]{"cn","mail","memberOf"}
            sc.setReturningAttributes(null);

            // 4. 執行搜尋
            NamingEnumeration<SearchResult> results = ctx.search(searchBase, searchFilter, sc);

            // 5. 處理搜尋結果
            if (!results.hasMore()) {
                System.out.println("找不到符合條件的使用者。");
            }
            while (results.hasMore()) {
                SearchResult sr = results.next();
                Attributes attrs = sr.getAttributes();
                System.out.println("---- 使用者 DN: " + sr.getNameInNamespace() + " ----");
                NamingEnumeration<? extends Attribute> allAttrs = attrs.getAll();
                while (allAttrs.hasMore()) {
                    Attribute attr = allAttrs.next();
                    System.out.printf("%s: %s%n", attr.getID(), attr.get());
                }
            }

        } catch (Exception e) {
            System.err.println("LDAP 搜尋失敗: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 6. 關閉連線
            if (ctx != null) {
                try { ctx.close(); } catch (Exception ignore) {}
            }
        }
    }
}
