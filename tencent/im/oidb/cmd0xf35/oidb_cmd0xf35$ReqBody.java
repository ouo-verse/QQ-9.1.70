package tencent.im.oidb.cmd0xf35;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf35$ReqBody extends MessageMicro<oidb_cmd0xf35$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"block_user_req"}, new Object[]{null}, oidb_cmd0xf35$ReqBody.class);
    public oidb_cmd0xf35$BlockUserReq block_user_req = new MessageMicro<oidb_cmd0xf35$BlockUserReq>() { // from class: tencent.im.oidb.cmd0xf35.oidb_cmd0xf35$BlockUserReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"first_comment_id", "sub_comment_id", "comment_type", "comment_source"}, new Object[]{"", "", 0, 0}, oidb_cmd0xf35$BlockUserReq.class);
        public final PBStringField first_comment_id = PBField.initString("");
        public final PBStringField sub_comment_id = PBField.initString("");
        public final PBUInt32Field comment_type = PBField.initUInt32(0);
        public final PBUInt32Field comment_source = PBField.initUInt32(0);
    };
}
