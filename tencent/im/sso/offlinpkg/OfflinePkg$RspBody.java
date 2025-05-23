package tencent.im.sso.offlinpkg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class OfflinePkg$RspBody extends MessageMicro<OfflinePkg$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBBytesField str_err_desc;
    public final PBBytesField str_expire_pkg;
    public final PBBytesField str_offline_pkg;
    public final PBBytesField str_predown_pkg;
    public final PBBytesField str_predown_pkg_ex;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"int32_ret", "str_err_desc", "str_expire_pkg", "str_predown_pkg", "str_predown_pkg_ex", "str_offline_pkg"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, OfflinePkg$RspBody.class);
    }

    public OfflinePkg$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_err_desc = PBField.initBytes(byteStringMicro);
        this.str_expire_pkg = PBField.initBytes(byteStringMicro);
        this.str_predown_pkg = PBField.initBytes(byteStringMicro);
        this.str_predown_pkg_ex = PBField.initBytes(byteStringMicro);
        this.str_offline_pkg = PBField.initBytes(byteStringMicro);
    }
}
