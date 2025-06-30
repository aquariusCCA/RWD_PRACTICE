import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import javax.xml.bind.DatatypeConverter;  // 若環境無此類別，可改用自訂轉碼函式
import java.util.Hashtable;
import java.util.Scanner;

public class LdapUserInfoDetail2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 由使用者輸入帳號 (userPrincipalName) 與密碼
        System.out.print("請輸入帳號 (userPrincipalName)：");
        String account = scanner.nextLine().trim();
        System.out.print("請輸入密碼：");
        String password = scanner.nextLine();

        // 2. 設定 LDAP 環境參數
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://10.253.1.99:389/DC=entiebank,DC=com,DC=tw");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, account + "@entiebank.com.tw"); // 使用 UPN 格式
        env.put(Context.SECURITY_CREDENTIALS, password);
        env.put(Context.REFERRAL, "follow");

        DirContext ctx = null;
        try {
            ctx = new InitialDirContext(env);
            System.out.println("LDAP 連線成功！");

            // 3. 指定要回傳的屬性
            String[] attrsToReturn = new String[] {
                "whenCreated", "objectCategory", "badPwdCount", "codePage", "mail",
                "objectGUID", "memberOf", "instanceType", "objectSid", "badPasswordTime",
                "dSCorePropagationData", "objectClass", "company", "name", "description",
                "sn", "userAccountControl", "primaryGroupID", "lastLogon", "accountExpires",
                "uSNChanged", "physicalDeliveryOfficeName", "cn", "logonCount", "sAMAccountType",
                "givenName", "uSNCreated", "displayName", "pwdLastSet", "userPrincipalName",
                "whenChanged", "lastLogonTimestamp", "department", "countryCode",
                "distinguishedName", "sAMAccountName"
            };

            SearchControls sc = new SearchControls();
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
            sc.setReturningAttributes(attrsToReturn);

            // 4. 以輸入的帳號作為搜尋條件
            String filter = String.format("(userPrincipalName=%s)", account);
            NamingEnumeration<SearchResult> results = ctx.search("", filter, sc);

            if (!results.hasMore()) {
                System.out.println("找不到符合條件的使用者：" + account);
                return;
            }

            // 5. 列出屬性與對應值
            while (results.hasMore()) {
                SearchResult sr = results.next();
                System.out.println("---- 使用者 DN: " + sr.getNameInNamespace() + " ----");
                Attributes attrs = sr.getAttributes();
                NamingEnumeration<? extends Attribute> allAttrs = attrs.getAll();

                while (allAttrs.hasMore()) {
                    Attribute attr = allAttrs.next();
                    NamingEnumeration<?> values = attr.getAll();

                    while (values.hasMore()) {
                        Object val = values.next();
                        if (val instanceof byte[]) {
                            String hex = DatatypeConverter.printHexBinary((byte[]) val);
                            System.out.printf("%s: %s%n", attr.getID(), hex);
                        } else {
                            System.out.printf("%s: %s%n", attr.getID(), val.toString());
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("LDAP 搜尋失敗: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (ctx != null) {
                try { ctx.close(); } catch (Exception ignored) {}
            }
            scanner.close();
        }
    }
}
