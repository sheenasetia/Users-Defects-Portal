# Users-Defects-Portal

** Microservice 1 --> User-service **
  id(auto generated)
  username
  password
  email
  phone number
  address
  
** Microservice 2 --> Defects-service **
  defect-id(auto generated)
  product name 
  defect details
  status (open/closed)
  date 
  username (user that stated it)
  
** Microservice 3 --> User-profile-service **
  consumes Microservice 1 @Rest Template
  consumes Microservice 2 @Feign Client
  
  Result : User info + Defect details
  
  
  
