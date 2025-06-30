import javax.naming.Context;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.DirContext;
import java.util.Hashtable;

public class LdapConnectionTest {
    public static void main(String[] args) {
        // 1. 準備連線環境變數
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

        // ← 這裡改成新的 LDAP 主機 IP
        env.put(Context.PROVIDER_URL, "ldap://10.253.1.99:389/DC=entiebank,DC=com,DC=tw");

        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        // // 綁定 DN（以 CN 為例，若您使用 uid，請改成 UID=10192,…）
        // env.put(Context.SECURITY_PRINCIPAL,  "UID=10192,OU=Users,DC=entiebank,DC=com,DC=tw");
        // env.put(Context.SECURITY_CREDENTIALS, "Lins860210");
        // 改用 UPN 綁定
        env.put(Context.SECURITY_PRINCIPAL,  "10192@entiebank.com.tw");
        env.put(Context.SECURITY_CREDENTIALS, "Lins860210");

        DirContext ctx = null;
        try {
            // 2. 嘗試建立連線
            ctx = new InitialDirContext(env);
            System.out.println("LDAP 連線成功！");
        } catch (Exception e) {
            // 3. 連線失敗時印出錯誤
            System.err.println("LDAP 連線失敗: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 4. 關閉連線
            if (ctx != null) {
                try { ctx.close(); } catch (Exception ignore) {}
            }
        }
    }
}
