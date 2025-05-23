package tencent.im.oidb.cmd0xad7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xad7$RspBody extends MessageMicro<oidb_cmd0xad7$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_rsp_share"}, new Object[]{null}, oidb_cmd0xad7$RspBody.class);
    public oidb_cmd0xad7$RspShare msg_rsp_share = new MessageMicro<oidb_cmd0xad7$RspShare>() { // from class: tencent.im.oidb.cmd0xad7.oidb_cmd0xad7$RspShare
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_biu;
        public final PBBytesField bytes_friend;
        public final PBBytesField bytes_qzhone;
        public final PBBytesField bytes_wechat;
        public final PBBytesField bytes_wechat_dpyq;
        public final PBBytesField bytes_wechat_pyq;
        public final PBBytesField bytes_weibo;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{26, 34, 42, 50, 58, 66, 74}, new String[]{"bytes_friend", "bytes_qzhone", "bytes_wechat", "bytes_wechat_pyq", "bytes_wechat_dpyq", "bytes_weibo", "bytes_biu"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_cmd0xad7$RspShare.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_friend = PBField.initBytes(byteStringMicro);
            this.bytes_qzhone = PBField.initBytes(byteStringMicro);
            this.bytes_wechat = PBField.initBytes(byteStringMicro);
            this.bytes_wechat_pyq = PBField.initBytes(byteStringMicro);
            this.bytes_wechat_dpyq = PBField.initBytes(byteStringMicro);
            this.bytes_weibo = PBField.initBytes(byteStringMicro);
            this.bytes_biu = PBField.initBytes(byteStringMicro);
        }
    };
}
