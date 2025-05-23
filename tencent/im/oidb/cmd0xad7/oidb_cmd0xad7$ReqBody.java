package tencent.im.oidb.cmd0xad7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xad7$ReqBody extends MessageMicro<oidb_cmd0xad7$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 72}, new String[]{"msg_client", "msg_req_article", "uint32_friend", "uint32_qzhone", "uint32_wechat", "uint32_wechat_pyq", "uint32_wechat_dpyq", "uint32_weibo", "uint32_biu"}, new Object[]{null, null, 0, 0, 0, 0, 0, 0, 0}, oidb_cmd0xad7$ReqBody.class);
    public oidb_cmd0xad7$Client msg_client = new MessageMicro<oidb_cmd0xad7$Client>() { // from class: tencent.im.oidb.cmd0xad7.oidb_cmd0xad7$Client
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_version", "uint32_type"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_cmd0xad7$Client.class);
        public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    };
    public oidb_cmd0xad7$ReqArticle msg_req_article = new MessageMicro<oidb_cmd0xad7$ReqArticle>() { // from class: tencent.im.oidb.cmd0xad7.oidb_cmd0xad7$ReqArticle
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_article_id;
        public final PBBytesField bytes_row_key;
        public final PBBytesField bytes_url;
        public final PBUInt32Field uint32_prev_version;
        public final PBUInt64Field uint64_public_uin;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 96}, new String[]{"bytes_url", "uint64_public_uin", "bytes_article_id", "bytes_row_key", "uint32_prev_version"}, new Object[]{byteStringMicro, 0L, byteStringMicro, byteStringMicro, 0}, oidb_cmd0xad7$ReqArticle.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_url = PBField.initBytes(byteStringMicro);
            this.uint64_public_uin = PBField.initUInt64(0L);
            this.bytes_article_id = PBField.initBytes(byteStringMicro);
            this.bytes_row_key = PBField.initBytes(byteStringMicro);
            this.uint32_prev_version = PBField.initUInt32(0);
        }
    };
    public final PBUInt32Field uint32_friend = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzhone = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wechat = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wechat_pyq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_wechat_dpyq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_weibo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biu = PBField.initUInt32(0);
}
