## Phone parser lib
[![Actions Status: test](https://github.com/avraampiperidis/speechai/workflows/main/badge.svg)](https://github.com/avraampiperidis/speechai/actions?query=workflow%3A"tests")

#### Library usage
```java
Set<NumberRes> res = new PhoneGeneratorBuilder()
    .with("00 30 697 111 11 11")
	.skipGreekPhoneValidation(true).generate();
	//NumberRes.getPhone() : String
	//NumberRes.isValid() : boolean
```

### Compile and run tests
```java
git clone https://github.com/avraampiperidis/speechai.git
cd speechai
mvn compile
mvn test
//To run the demo Main class provided
cd numberchecker
mvn exec:java -Dexec.mainClass="com.omilia.it.runner.MainDemo"
```

### Standalone validators usage
```java
SimpleConstraintViolationException ex = new ValidationContext(new PhoneNumberValidator
                .ValidateGreekPhoneNumber(null,"6559884"),ValidationContext.DispatchOnFail.YES)
                .and(new PhoneNumberValidator
                .ValidateGreekPhoneNumber(null,"5545sdfas555"))
                .checkValidation();
assertEquals(2,ex.getErrors().size());
```

####  Packages
```java
//for base usage
com.omilia.it.core.*
//for standalone validators
com.omilia.it.validation.*
```
