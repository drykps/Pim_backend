package com.pim.blockchain.storage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlockchainStorageApplication.class)
@Transactional
public class BlockchainStorageApplicationTests {

	@Test
	public void contextLoads() {
	}

}

