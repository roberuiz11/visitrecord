Feature: Query by person or city
  Read a big file
  Return the answer to request (person or city)

  Scenario Outline: Query by city
    Given A data file
    When the city is "<city>"
    Then the people are "<people>"
    Examples:
      | city          | people                                                                                              |
      | BARCELONA     | 93654902Y,44340637H,54315871Z,04217040J,69429384C,54808168L,10863096N,58204706D,84604786E,23803975X |
      | CARTAGENA     | 69429384C                                                                                           |
      | LONDON        | 51011156P,61682270L,15015516N,87179151C                                                             |
      | MADRID        | 54808168L                                                                                           |
      | SAN FRANCISCO | 25384390A,54315871Z,21743514G,04810023X,38399984N                                                   |

  Scenario Outline: Query by person ID
    Given A data file
    When The id is <id>
    Then the person have been in "<cities>"
    Examples:
      | id        | cities                  |
      | 54808168L | MADRID,BARCELONA,OVIEDO |
      | 93654902Y | BARCELONA               |
      | 25384390A | SAN FRANCISCO,LAS VEGAS |
      | 54315871Z | SAN FRANCISCO,BARCELONA |
      | 09877359D | LAS VEGAS,NEW YORK      |

