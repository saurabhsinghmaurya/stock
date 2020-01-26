package beans;

public class ConnectionBean {
static String user;
static String password;
static int port;
public static String getUser() {
	return user;
}
public static void setUser(String user) {
	ConnectionBean.user = user;
}
public static String getPassword() {
	return password;
}
public static void setPassword(String password) {
	ConnectionBean.password = password;
}
public static int getPort() {
	return port;
}
public static void setPort(int port) {
	ConnectionBean.port = port;
}


}
