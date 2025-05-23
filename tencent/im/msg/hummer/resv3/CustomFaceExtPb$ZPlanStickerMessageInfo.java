package tencent.im.msg.hummer.resv3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class CustomFaceExtPb$ZPlanStickerMessageInfo extends MessageMicro<CustomFaceExtPb$ZPlanStickerMessageInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_action_name;
    public final PBBytesField bytes_pic_url;
    public final PBBytesField bytes_reserve_info;
    public final PBUInt32Field uint32_action_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_action_type;
    public final PBUInt32Field uint32_meme_height;
    public final PBUInt32Field uint32_meme_width;
    public final PBUInt32Field uint32_player_number;
    public final PBUInt64Field uint64_peer_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 58, 64, 72}, new String[]{"uint32_action_id", "bytes_action_name", "uint32_player_number", "uint32_action_type", "uint64_peer_uin", "bytes_pic_url", "bytes_reserve_info", "uint32_meme_width", "uint32_meme_height"}, new Object[]{0, byteStringMicro, 0, 0, 0L, byteStringMicro, byteStringMicro, 0, 0}, CustomFaceExtPb$ZPlanStickerMessageInfo.class);
    }

    public CustomFaceExtPb$ZPlanStickerMessageInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_action_name = PBField.initBytes(byteStringMicro);
        this.uint32_player_number = PBField.initUInt32(0);
        this.uint32_action_type = PBField.initUInt32(0);
        this.uint64_peer_uin = PBField.initUInt64(0L);
        this.bytes_pic_url = PBField.initBytes(byteStringMicro);
        this.bytes_reserve_info = PBField.initBytes(byteStringMicro);
        this.uint32_meme_width = PBField.initUInt32(0);
        this.uint32_meme_height = PBField.initUInt32(0);
    }
}
