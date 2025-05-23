package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8dd$Cookie extends MessageMicro<oidb_0x8dd$Cookie> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"msg_ckv_cookie", "bytes_dcache_cookie", "msg_anchor_cookie", "page_cnt"}, new Object[]{null, ByteStringMicro.EMPTY, null, 0}, oidb_0x8dd$Cookie.class);
    public oidb_0x8dd$CkvCookie msg_ckv_cookie = new MessageMicro<oidb_0x8dd$CkvCookie>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$CkvCookie
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_index", "uint32_uin", "uint32_end"}, new Object[]{0, 0, 0}, oidb_0x8dd$CkvCookie.class);
        public final PBUInt32Field uint32_index = PBField.initUInt32(0);
        public final PBUInt32Field uint32_uin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_end = PBField.initUInt32(0);
    };
    public final PBBytesField bytes_dcache_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8dd$AnchorCookie msg_anchor_cookie = new MessageMicro<oidb_0x8dd$AnchorCookie>() { // from class: tencent.im.oidb.cmd0x8dd.oidb_0x8dd$AnchorCookie
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_index"}, new Object[]{0}, oidb_0x8dd$AnchorCookie.class);
        public final PBUInt32Field uint32_index = PBField.initUInt32(0);
    };
    public final PBUInt32Field page_cnt = PBField.initUInt32(0);
}
