# wallet-backend-reference

This is a repository containing code and decisions that we have agreed upon to use when building the backend services for the wallet.

This repository might or might not be updated once we have our first few services.


## Code standard/decision
    * Records are to be used to create immutable data classes
    * Recordbuilder should always be applied and be the recommended, but not mandatory method, for creating data classes.
    * Creation of record classes, migration between classes should be done in mapper functions.