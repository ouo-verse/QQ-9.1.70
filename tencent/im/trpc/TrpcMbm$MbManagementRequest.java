package tencent.im.trpc;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcMbm$MbManagementRequest extends MessageMicro<TrpcMbm$MbManagementRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"mbm_head_info", "set_mbphone_req"}, new Object[]{null, null}, TrpcMbm$MbManagementRequest.class);
    public TrpcMbm$MbmHeadInfo mbm_head_info = new TrpcMbm$MbmHeadInfo();
    public TrpcMbm$SetMbPhoneReq set_mbphone_req = new TrpcMbm$SetMbPhoneReq();
}
