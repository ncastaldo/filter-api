# Filter API

## Description

An application manages access to “resource” objects (e.g a user) and we need to provide a Java API for querying the set of available resources. 

One of the requirements for the query API is to have filtering functionality allowing clients to select resources which match certain criteria. 

For the sake of simplicity, a “resource” is represented using a `Map<String,String>` which maps “property” names (keys) to their values. Property names are case sensitive, but property values are not.

## Task

Design and implement a “Filter” API which can be used to determine whether or not a resource matches a given set of criteria. More specifically, the filter API should provide the following functionality:

The ability to determine whether or not a filter matches a given resource (where a resource is represented using a `Map<String,String>`).


## Support

- boolean literals: true and false
- logical operators which can be used to combine the results of other filters
  - AND 
  - OR
  - NOT
- comparison operators (care should be taken to deal with missing properties)
  - property is present
  - property is equal to some value
  - property is less than some value
  - property is greater than some value
  - property matches a regular expression
- the ability to programmatically construct arbitrarily complex filters
- a string representation, including the ability to generate and parse filters from the string representation

## Implementation

In a nutshell: all filters implement a common `Filter` interface and offer a `matches` method that contains the logic of each specific filter; all filters can be combined with AND, OR and NOT logical operator.

See `/resources/model.png` for the UML Class Diagram and take a look at the JavaDoc for more details.


## Extensibility

1. **Consider how the API could be extended to include support for new types of filter.**
If a new type of filter is needed, the new class must implement the Filter interface. 
In case the Filter uses some property of the input resource, the PropertyFilter abstract class must be used in order to exploit the property existence checks already implemented. 
In the case the new filter has a String (or JSON) representation that needs to be parsed, a new FilterKey must be added to the related Enum, as well as the code to parse it in the FilterBuilder class.

2. **Consider how the API could support 3rd party applications which need to perform some logic based on the structure and content of a filter in a type-safe manner.**
The filters are highly structured and all the logic is reduced to the a few lines of code which define the actual behavior of each filter. 
A complex filter is represented by different series of filters organized with logical operators and in a modular manner.
To manage the logic of such complex filters, a 3rd party application could act on each simple filter individually, defining additional behavior/functionalites independently.


## Example

The main example can be found in the `/test/filter_api/FilterApiTest.java` JUnit 4 file.
