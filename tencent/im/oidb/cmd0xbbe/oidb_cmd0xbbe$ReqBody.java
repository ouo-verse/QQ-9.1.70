package tencent.im.oidb.cmd0xbbe;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbbe$ReqBody extends MessageMicro<oidb_cmd0xbbe$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"msg_get_recommend_account_req", "uint64_article_id", "bytes_info_cookie"}, new Object[]{null, 0L, ByteStringMicro.EMPTY}, oidb_cmd0xbbe$ReqBody.class);
    public oidb_cmd0xbbe$GetRecommendAccountReq msg_get_recommend_account_req = new MessageMicro<oidb_cmd0xbbe$GetRecommendAccountReq>() { // from class: tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe$GetRecommendAccountReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0xbbe$GetRecommendAccountReq.class);
    };
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0);
    public final PBBytesField bytes_info_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
