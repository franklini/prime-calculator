# prime-calculator
Restful App for calculating prime primes
This Project will provide several prime number calculator methods that will be exposed via restful services.
It uses Spring Boot for it simplicity (no config files). it uses maven for build and JUnit for testing.
It requires Java 8 to run.

run 'mvn clean install' or use you favourite IDE. then run the main method in PrimeCalculatorApp.

the following HTTP get requests can be accepted by the app (note: mapping name describes the method functionality)

http://localhost:8080/isPrime?number={toInvestigate}

e.g 	'http://localhost:8080/isPrime?number=6' returns false
	'http://localhost:8080/isPrime?number=7' returns true



http://localhost:8080/primesWithinRange?number={rangeToInvestigate}

e.g	'http://localhost:8080/primesWithinRange?number=10' returns [2,3,5,7]



the rest is similar

http://localhost:8080/primesWithinRangeUsingParallelStream?number={rangeToInvestigate}


http://localhost:8080/highestPrimeWithinRangeByForkJoin?number={rangeToInvestigate}


http://localhost:8080/highestPrimeWithinRangeBestSolution?number={rangeToInvestigate}