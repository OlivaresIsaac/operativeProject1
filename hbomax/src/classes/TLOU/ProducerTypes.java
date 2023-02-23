/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

import classes.PTypes;

/**
 *
 * @author dsre1
 */
public class ProducerTypes {
    
    private final int numProducerTypes;
    private final ProducerType[] producerTypes;

    public ProducerTypes(int numProducerTypes) {
        this.numProducerTypes = numProducerTypes;
        this.producerTypes = this.setProducerTypes();
    }
    
    private ProducerType[] setProducerTypes() {
        ProducerType intro = new ProducerType(PTypes.intro, 5, 3, 1);
        ProducerType credit = new ProducerType(PTypes.credit, 3, 3, 1);
        ProducerType start = new ProducerType(PTypes.start, 7, 1, 4);
        ProducerType end = new ProducerType(PTypes.end, 7.5, 1, 3);
        ProducerType twist = new ProducerType(PTypes.twist, 10, 1, 3);

        ProducerType[] aux = {intro, credit, start, end, twist};

        return aux;
    }
    
    public ProducerType getProducerType(String id) {
        for (int i = 0; i < this.numProducerTypes; i++) {
            ProducerType aux = this.producerTypes[i];
            if (aux.getId().equals(id)) {
                return aux;
            }
        }
        return null;
    }
    
}
