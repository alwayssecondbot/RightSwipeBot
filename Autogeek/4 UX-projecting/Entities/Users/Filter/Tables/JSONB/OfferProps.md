Jsonb which contains filter offers properties.

| Field name      | Data type | Not Null | Default | Description                                                                                          |
| --------------- | --------- | -------- | ------- | ---------------------------------------------------------------------------------------------------- |
| owners          | bytea     | -        | -       | Owners quantity                                                                                      |
| is_vrc_original | boolean   | -        | -       | VRC original                                                                                         |
| offer_types     | bytea     | -        | -       | Offer types from [[Autogeek/4 UX-projecting/Entities/Users/Offer/Tables/enums/OfferType\|OfferType]] |
| was_in_accident | boolean   | -        | -       | Was car in accident                                                                                  |
| may_be_changed  | boolean   | -        | -       | May car be changed                                                                                   |
| has_guarantee   | boolean   | -        | -       | Has car a guarantee                                                                                  |

```
offer_props: [
	owners: [...],
	is_vrc_original: true,
	offer_types: [...],
	was_in_accident: [true\false],
	may_be_changed: true,
	has_guarantee: true
]
```