package tencent.im.trpc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcMbm$MbmHeadInfo extends MessageMicro<TrpcMbm$MbmHeadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"user_mbm_info", "safe_check_info", "alias_info"}, new Object[]{null, null, null}, TrpcMbm$MbmHeadInfo.class);
    public TrpcMbm$UserMbmInfo user_mbm_info = new TrpcMbm$UserMbmInfo();
    public TrpcMbm$SafeCheckInfo safe_check_info = new TrpcMbm$SafeCheckInfo();
    public TrpcMbm$AliasInfo alias_info = new MessageMicro<TrpcMbm$AliasInfo>() { // from class: tencent.im.trpc.TrpcMbm$AliasInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ignore_rsp"}, new Object[]{Boolean.FALSE}, TrpcMbm$AliasInfo.class);
        public final PBBoolField ignore_rsp = PBField.initBool(false);
    };
}
