package tencent.im.oidb.cmd0xa70;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xa70$ReqBody extends MessageMicro<oidb_cmd0xa70$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint64_uin", "msg_video_req_info"}, new Object[]{0L, null}, oidb_cmd0xa70$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public oidb_cmd0xa70$VideoReqInfo msg_video_req_info = new MessageMicro<oidb_cmd0xa70$VideoReqInfo>() { // from class: tencent.im.oidb.cmd0xa70.oidb_cmd0xa70$VideoReqInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_wangzhe_share_url"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0xa70$VideoReqInfo.class);
        public final PBBytesField bytes_wangzhe_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
