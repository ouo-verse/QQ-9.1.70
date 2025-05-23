package tencent.im.oidb;

import appoint.define.appoint_define$LBSInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x5fb$ReqBody extends MessageMicro<cmd0x5fb$ReqBody> {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_LBS_INFO_FIELD_NUMBER = 2;
    public static final int REQ_INFO_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_head", "msg_lbs_info", "req_info"}, new Object[]{null, null, ByteStringMicro.EMPTY}, cmd0x5fb$ReqBody.class);
    public cmd0x5fb$BusiReqHead msg_head = new MessageMicro<cmd0x5fb$BusiReqHead>() { // from class: tencent.im.oidb.cmd0x5fb$BusiReqHead
        public static final int INT32_SEQ_FIELD_NUMBER = 2;
        public static final int INT32_VERSION_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_version", "int32_seq"}, new Object[]{1, 0}, cmd0x5fb$BusiReqHead.class);
        public final PBInt32Field int32_version = PBField.initInt32(1);
        public final PBInt32Field int32_seq = PBField.initInt32(0);
    };
    public appoint_define$LBSInfo msg_lbs_info = new appoint_define$LBSInfo();
    public final PBBytesField req_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
