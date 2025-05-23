package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6c3$ImgShowItem extends MessageMicro<oidb_0x6c3$ImgShowItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cut_wording;
    public final PBBytesField bytes_wording;
    public final PBUInt32Field uint32_productid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_price = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_productid", "uint32_price", "bytes_wording", "bytes_cut_wording"}, new Object[]{0, 0, byteStringMicro, byteStringMicro}, oidb_0x6c3$ImgShowItem.class);
    }

    public oidb_0x6c3$ImgShowItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_wording = PBField.initBytes(byteStringMicro);
        this.bytes_cut_wording = PBField.initBytes(byteStringMicro);
    }
}
