package tencent.im.oidb.cmd0x991;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$VideoFile;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x991$Goods extends MessageMicro<oidb_cmd0x991$Goods> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_animation_param;
    public final PBBytesField bytes_goods_name;
    public final PBInt32Field int32_goods_price;
    public final PBInt32Field int32_product_id = PBField.initInt32(0);
    public im_msg_body$CustomFace msg_img;
    public im_msg_body$VideoFile msg_video;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50}, new String[]{"int32_product_id", "bytes_goods_name", "int32_goods_price", "bytes_animation_param", "msg_video", "msg_img"}, new Object[]{0, byteStringMicro, 0, byteStringMicro, null, null}, oidb_cmd0x991$Goods.class);
    }

    public oidb_cmd0x991$Goods() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_goods_name = PBField.initBytes(byteStringMicro);
        this.int32_goods_price = PBField.initInt32(0);
        this.bytes_animation_param = PBField.initBytes(byteStringMicro);
        this.msg_video = new im_msg_body$VideoFile();
        this.msg_img = new im_msg_body$CustomFace();
    }
}
