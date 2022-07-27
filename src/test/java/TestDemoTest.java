 import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();    //may be a possible problem down the road? question 4.a
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 2, 4, false),
				arguments(1, 3, 4, false),
				arguments(6, 1, 7, false),
				arguments(-2, 2, 0, true),
				arguments(1, -5, -4, true),
				arguments(-3, -4, -7, true),
				arguments(0, 5, 5, true),
				arguments(7, 0, 7, true)
				
				);
		
		
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			}else {
				assertThatThrownBy(() -> 
			    testDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);

			}

	}
	
	
	
	@Test
	
	void assertThatNumberSquaredIsCorrect(){
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
	

}
