package com.danielqueiroz.mycommerce.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderedItemID implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "order_id")
    private Long orderId;

    @EqualsAndHashCode.Include
    @Column(name = "product_id")
    private Long productId;

}
