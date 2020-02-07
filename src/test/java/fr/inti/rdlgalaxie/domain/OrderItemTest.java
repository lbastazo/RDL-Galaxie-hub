package fr.inti.rdlgalaxie.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import fr.inti.rdlgalaxie.web.rest.TestUtil;

public class OrderItemTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(OrderItem.class);
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setId("id1");
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setId(orderItem1.getId());
        assertThat(orderItem1).isEqualTo(orderItem2);
        orderItem2.setId("id2");
        assertThat(orderItem1).isNotEqualTo(orderItem2);
        orderItem1.setId(null);
        assertThat(orderItem1).isNotEqualTo(orderItem2);
    }
}
