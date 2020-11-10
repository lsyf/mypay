package com.mypay.account.api.req;

import com.mypay.common.base.RpcRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FreezeRequest extends RpcRequest {

    @NotNull
    Long accountId;
    @NotNull
    Long amount;

    @NotBlank
    String currency;

    @NotBlank
    String bizId;
    String bizType;
    String bizInfo;

}
