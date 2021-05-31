
## Installing dependencies wthout running tests

    mvn clean install -Dcucumber.filter.tags='@null'

## Configuration
- Set Your test configurations in [src/test/resources/org/openelisglobal/qaframework/test.properties](./src/test/resources/org/openelisglobal/qaframework/test.properties)

- See Feature files under [src/features/openelis](./src/features/openelis)

### Running test projects

1. All OE-tests

        mvn test

2. login tests only

       mvn test -Dcucumber.filter.tags='@login'
