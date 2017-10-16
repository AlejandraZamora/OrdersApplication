# OrdersApplcation
___

## Documentación servicios web
___

## API REST

Tipo de datos manejado:  ***JSON***

### Recursos

El API ofrece el siguiente recurso principal:

- customer

Este se puede usar así:

### Componentes de los recursos

| Recurso | Metodo | Descripción | Parametro | Retorno |
| :------ | :----- | :---------- | :-------- | :------ |
| `/customer/` | **GET** | Retorna todoso los clientes registrados en la base de datos. | | **List \<DataPOJO>** |
| `/customer/{customerId}/` | **GET** | Retorna el cliente registrado en la base de datos específicado por su identificador.| **Integer** | **DataPOJO** |
| `/customer/{customerId}/order` | **GET** | Consulta las ordenes registradas en la base de datos para el cliente especificado por el identificador. | **Integer** | **List \<DataPOJO>** |
| `/customer/{customerId}/order` | **POST** | Registra una nueva orden en la base de datos para el cliente especificado por el identificador. | **Integer, DataPOJO** | |
| `/customer/{customerId}/product` | **GET** | Consulta los productos disponibles registrados en la base de datos para el cliente especificado por el identificador. | **Integer** | **List \<DataPOJO>** |


### Parametros de URL

| Nombre | Tipo | Descripción |
| :----- | :--- | :---------- |
| *customerId* | **Integer**| Número de identificación del cliente. |

### Forma de datos

#### Customer

	{	
      "customerId":Integer,
      "name":String, 
      "email":String
	}

#### Order
  
  	{ 
      "orderId":Integer,
      "customer":Customer,
      "deliveryAddress":Integer,
      "creationDate":Calendar,
      "orderDetails":List<OrderDetail>
  	}

#### OrderDetail

	{
      "orderDetailId":Integer,
      "productDescription":String,
      "price":Integer
	}

#### Product

  	{
      "productId":Integer,
      "name":String,
      "price":Integer,
      "customerProducts":List<CustomerProduct>
  	}

#### CustomerProduct

  	{
      "customerProductId":CustomerProductId,
      "product":Product
  	}
    

#### CustomerProductID

  	{
      "productId":Integer,
      "customerId":Integer
  	}
_______
