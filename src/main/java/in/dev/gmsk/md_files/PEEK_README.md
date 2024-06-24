# peek

    Stream<T> peek(Consumer<? super T> action)

 Returns a stream consisting of the elements of this stream, additionallyperforming the provided action on each element as elements are consumedfrom the resulting stream. 

 `This is an intermediateoperation.`
 For parallel stream pipelines, the action may be called atwhatever time and in whatever thread the element is made available by theupstream operation. If the action modifies shared state,it is responsible for providing the required synchronization.

 **API Note:** This method exists mainly to support debugging, where you wantto see the elements as they flow past a certain point in a pipeline: 

    Stream.of("one", "two", "three", "four")
        .filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());

 `Parameters:action` - a non-interfering action to perform on the elements asthey are consumed from the streamReturns:the new stream.
