@file:OptIn(ExperimentalCoroutinesApi::class)

package com.solana.api
import com.solana.Solana
import com.solana.core.PublicKey
import com.solana.models.buffer.AccountInfo
import com.solana.networking.OkHttpNetworkingRouter
import com.solana.networking.RPCEndpoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class ApiTests {

    val solana: Solana get() = Solana(OkHttpNetworkingRouter(RPCEndpoint.devnetSolana))

    @Test
    fun TestGetRecentBlockhash() = runTest {
        val result: Any = solana.api.getRecentBlockhash()
        Assert.assertNotNull(result)
    }

    @Test
    fun TestGetBlock() = runTest {
        val result: Any = solana.api.getBlock(164039401)
        Assert.assertNotNull(result)
    }

    @Test
    fun TestGetBlockCommitment() = runTest {
        val result: Any = solana.api.getBlockCommitment(82493733)
        Assert.assertNotNull(result)
    }

    @Test
    fun TestGetBlockHeight() = runTest {
        val result: Any = solana.api.getBlockHeight()
        Assert.assertNotNull(result)
    }

    @Test
    fun TestGetBlockTime() = runTest {
        val height = solana.api.getBlockHeight().getOrThrow()
        val result = solana.api.getBlockTime(height)
        Assert.assertNotNull(result)
    }

    @Test
    fun TestGetClusterNodes() = runTest {
        val result = solana.api.getClusterNodes()
        Assert.assertNotNull(result)
    }
}