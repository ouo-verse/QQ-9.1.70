package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e7$ReqBody extends MessageMicro<oidb_0x8e7$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_0x8e7$ExtParam msg_ext_parm = new MessageMicro<oidb_0x8e7$ExtParam>() { // from class: tencent.im.oidb.oidb_0x8e7.oidb_0x8e7$ExtParam
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"msg_login_sig", "bytes_version", "uint32_portal", "uint32_client"}, new Object[]{null, ByteStringMicro.EMPTY, 0, 0}, oidb_0x8e7$ExtParam.class);
        public oidb_0x8e7$LoginSig msg_login_sig = new MessageMicro<oidb_0x8e7$LoginSig>() { // from class: tencent.im.oidb.oidb_0x8e7.oidb_0x8e7$LoginSig
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_type", "bytes_sig", "uint32_appid"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, oidb_0x8e7$LoginSig.class);
            public final PBUInt32Field uint32_type = PBField.initUInt32(0);
            public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
        };
        public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
        public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    };
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBBoolField bool_stock = PBField.initBool(false);
    public final PBBoolField bool_is_first = PBField.initBool(false);
    public final PBBoolField bool_need_warn = PBField.initBool(false);
    public final PBBoolField bool_need_update_url = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56}, new String[]{"msg_ext_parm", "uint64_uin", "uint64_tinyid", "bool_stock", "bool_is_first", "bool_need_warn", "bool_need_update_url"}, new Object[]{null, 0L, 0L, bool, bool, bool, bool}, oidb_0x8e7$ReqBody.class);
    }
}
