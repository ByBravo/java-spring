package cl.commander.micro_inventory.viewmodel;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;


/**
 * ProductRequest
 */

public class ProductRequest   {
  @JsonProperty("barcode")
  private String barcode;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("salePrice")
  private Integer salePrice;

  @JsonProperty("purchasePrice")
  private Integer purchasePrice;

  @JsonProperty("categoryId")
  private String categoryId;

  @JsonProperty("supplierId")
  private String supplierId;

  public ProductRequest barcode(String barcode) {
    this.barcode = barcode;
    return this;
  }

  /**
   * Corresponds to the barcode of the product
   * @return barcode
  */
  @ApiModelProperty(value = "Corresponds to the barcode of the product")


  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public ProductRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Corresponds to the name of the product
   * @return name
  */
  @ApiModelProperty(value = "Corresponds to the name of the product")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Corresponds to the description of the product
   * @return description
  */
  @ApiModelProperty(value = "Corresponds to the description of the product")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductRequest quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Corresponds to the quantity of the product on the inventory
   * @return quantity
  */
  @ApiModelProperty(value = "Corresponds to the quantity of the product on the inventory")


  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public ProductRequest salePrice(Integer salePrice) {
    this.salePrice = salePrice;
    return this;
  }

  /**
   * Corresponds to the salePrice of the product
   * @return salePrice
  */
  @ApiModelProperty(value = "Corresponds to the salePrice of the product")


  public Integer getSalePrice() {
    return salePrice;
  }

  public void setSalePrice(Integer salePrice) {
    this.salePrice = salePrice;
  }

  public ProductRequest purchasePrice(Integer purchasePrice) {
    this.purchasePrice = purchasePrice;
    return this;
  }

  /**
   * Corresponds to the purchasePrice of the product
   * @return purchasePrice
  */
  @ApiModelProperty(value = "Corresponds to the purchasePrice of the product")


  public Integer getPurchasePrice() {
    return purchasePrice;
  }

  public void setPurchasePrice(Integer purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  public ProductRequest categoryId(String categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * Corresponds to the category of the product
   * @return categoryId
  */
  @ApiModelProperty(value = "Corresponds to the category of the product")


  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public ProductRequest supplierId(String supplierId) {
    this.supplierId = supplierId;
    return this;
  }

  /**
   * Corresponds to the supplierId of the product
   * @return supplierId
  */
  @ApiModelProperty(value = "Corresponds to the supplierId of the product")


  public String getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(String supplierId) {
    this.supplierId = supplierId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductRequest productRequest = (ProductRequest) o;
    return Objects.equals(this.barcode, productRequest.barcode) &&
        Objects.equals(this.name, productRequest.name) &&
        Objects.equals(this.description, productRequest.description) &&
        Objects.equals(this.quantity, productRequest.quantity) &&
        Objects.equals(this.salePrice, productRequest.salePrice) &&
        Objects.equals(this.purchasePrice, productRequest.purchasePrice) &&
        Objects.equals(this.categoryId, productRequest.categoryId) &&
        Objects.equals(this.supplierId, productRequest.supplierId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(barcode, name, description, quantity, salePrice, purchasePrice, categoryId, supplierId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductRequest {\n");
    
    sb.append("    barcode: ").append(toIndentedString(barcode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    salePrice: ").append(toIndentedString(salePrice)).append("\n");
    sb.append("    purchasePrice: ").append(toIndentedString(purchasePrice)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    supplierId: ").append(toIndentedString(supplierId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

