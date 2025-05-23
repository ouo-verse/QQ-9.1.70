package tencent.im.sso.offlinpkg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class OfflinePkg$ReqBody extends MessageMicro<OfflinePkg$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field int32_network;
    public final PBBytesField str_from;
    public final PBBytesField str_osbrand;
    public final PBBytesField str_osmodel;
    public final PBBytesField str_osrelease;
    public final PBBytesField str_osver;
    public final PBBytesField str_qver;
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
    public final PBRepeatMessageField<OfflinePkg$BidPkg> st_bid_pkg = PBField.initRepeatMessage(OfflinePkg$BidPkg.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 72, 82}, new String[]{"uint32_cmd", "uint32_platform", "st_bid_pkg", "str_qver", "str_osver", "str_osrelease", "str_osbrand", "str_osmodel", "int32_network", "str_from"}, new Object[]{0, 0, null, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro}, OfflinePkg$ReqBody.class);
    }

    public OfflinePkg$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_qver = PBField.initBytes(byteStringMicro);
        this.str_osver = PBField.initBytes(byteStringMicro);
        this.str_osrelease = PBField.initBytes(byteStringMicro);
        this.str_osbrand = PBField.initBytes(byteStringMicro);
        this.str_osmodel = PBField.initBytes(byteStringMicro);
        this.int32_network = PBField.initInt32(0);
        this.str_from = PBField.initBytes(byteStringMicro);
    }
}
