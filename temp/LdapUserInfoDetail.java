import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import javax.xml.bind.DatatypeConverter;  // 若環境無此類別，可改用自訂轉碼函式
import java.util.Hashtable;

public class LdapUserInfoDetail {
    public static void main(String[] args) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://10.253.1.99:389/DC=entiebank,DC=com,DC=tw");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "10192@entiebank.com.tw");
        env.put(Context.SECURITY_CREDENTIALS, "Lins860210");
        env.put(Context.REFERRAL, "follow");

        DirContext ctx = null;
        try {
            ctx = new InitialDirContext(env);
            System.out.println("LDAP 連線成功！");

            // 指定要回傳的屬性
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

            // 空字串代表從 PROVIDER_URL 後整棵樹搜尋
            NamingEnumeration<SearchResult> results =
                ctx.search("", "(userPrincipalName=10192@entiebank.com.tw)", sc);

            if (!results.hasMore()) {
                System.out.println("找不到符合條件的使用者。");
                return;
            }

            while (results.hasMore()) {
                SearchResult sr = results.next();
                System.out.println("---- 使用者 DN: " + sr.getNameInNamespace() + " ----");
                Attributes attrs = sr.getAttributes();
                NamingEnumeration<? extends Attribute> allAttrs = attrs.getAll();

                while (allAttrs.hasMore()) {
                    Attribute attr = allAttrs.next();
                    NamingEnumeration<?> values = attr.getAll();

                    // 可能有多值屬性
                    while (values.hasMore()) {
                        Object val = values.next();

                        // 二進位屬性需轉成十六進位顯示
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
        }
    }
}
