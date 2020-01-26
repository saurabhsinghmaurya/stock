package beans;

public class User {
 static String name;
 static String email;
 static String post;
public static String getName() {
	return name;
}
public static void setName(String name) {
	User.name = name;
}
public static String getEmail() {
	return email;
}
public static void setEmail(String email) {
	User.email = email;
}
public static String getPost() {
	return post;
}
public static void setPost(String post) {
	User.post = post;
}


}
