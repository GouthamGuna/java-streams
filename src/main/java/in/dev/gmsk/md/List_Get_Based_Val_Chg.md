# How to change the list of object get index pick the object value and change using stream

 To change the list of objects, get the index of the object, pick the object value, and change it using the Stream API, you can use the following approach:

 First, create a stream from your list of objects. Then, use the findFirst() method to get the first element that matches the condition you specify. You can use a lambda expression to specify the condition. The findFirst() method returns an Optional, which is a container that may or may not contain a value.

 **Here’s an example:**
 
		List<User> users = Arrays.asList(new User("John"), new User("Alice"), new User("Bob"), new User("John"));

		Optional<Integer> index = users.stream()
			.filter(user -> user.getName().equals("John"))
			.mapToInt(user -> users.indexOf(user))
			.findFirst();

		if (index.isPresent()) {
			int userInd = index.get();
			users.set(userInd, new User("New Name"));
		}
		
 In this example, we create a stream from the list of users. We then use the `filter()` method to select only the users with the name “John”. 
 We use the `mapToInt()` method to convert the stream of users to a stream of indices, and then use the `findFirst()` method to get the index of the first user with the name “John”.
 Finally, we use the `isPresent()` method to check if the index is present, and if so, we get the index using the `get()` method. We then use the index to change the name of the user.
 
 **Note** That if there are multiple users with the name “John”, this code will only change the name of the first one. 
 If you want to change the name of all users with the name “John”, you can use the `forEach()` method instead of `findFirst()`:
 
	 users.stream()
		.filter(user -> user.getName().equals("John"))
		.forEach(user -> users.set(users.indexOf(user), new User("New Name")));
		
 This will change the name of all users with the name “John” to “New Name”.