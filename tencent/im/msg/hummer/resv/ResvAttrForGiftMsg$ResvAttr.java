package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ResvAttrForGiftMsg$ResvAttr extends MessageMicro<ResvAttrForGiftMsg$ResvAttr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 58, 66}, new String[]{"int32_send_score", "int32_recv_score", "bytes_charm_heroism", "uint32_button_flag", "uint32_obj_color", "uint32_animation_type", "msg_interact_gift", "activity_gift_info"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0, 0, 0, null, null}, ResvAttrForGiftMsg$ResvAttr.class);
    public final PBInt32Field int32_send_score = PBField.initInt32(0);
    public final PBInt32Field int32_recv_score = PBField.initInt32(0);
    public final PBBytesField bytes_charm_heroism = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_button_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_obj_color = PBField.initUInt32(0);
    public final PBUInt32Field uint32_animation_type = PBField.initUInt32(0);
    public ResvAttrForGiftMsg$InteractGift msg_interact_gift = new ResvAttrForGiftMsg$InteractGift();
    public ResvAttrForGiftMsg$ActivityGiftInfo activity_gift_info = new ResvAttrForGiftMsg$ActivityGiftInfo();
}
