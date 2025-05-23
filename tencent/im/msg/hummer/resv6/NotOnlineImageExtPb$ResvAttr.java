package tencent.im.msg.hummer.resv6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class NotOnlineImageExtPb$ResvAttr extends MessageMicro<NotOnlineImageExtPb$ResvAttr> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_original_image_md5_new;
    public final PBBytesField bytes_text_summary;
    public NotOnlineImageExtPb$ZPlanStickerMessageInfo msg_zplan_sticker;
    public final PBStringField string_ad_emo_desc_str;
    public final PBStringField string_ad_emo_jump_url;
    public final PBStringField string_camera_capture_materialname;
    public final PBStringField string_camera_capture_templateinfo;
    public final PBStringField string_emoji_iconUrl;
    public final PBStringField string_emoji_marketFaceName;
    public final PBStringField string_emoji_source;
    public final PBStringField string_emoji_webUrl;
    public final PBUInt32Field uint32_emoji_from;
    public final PBUInt32Field uint32_source;
    public final PBUInt32Field uint32_image_biz_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_customface_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_emoji_packageid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_emoji_id = PBField.initUInt32(0);
    public final PBStringField string_text = PBField.initString("");
    public final PBStringField string_doutu_suppliers = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 66, 80, 90, 98, 106, 114, 120, 130, 138, 146, 154, 162, 250}, new String[]{"uint32_image_biz_type", "uint32_customface_type", "uint32_emoji_packageid", "uint32_emoji_id", "string_text", "string_doutu_suppliers", "bytes_text_summary", "uint32_emoji_from", "string_emoji_source", "string_emoji_webUrl", "string_emoji_iconUrl", "string_emoji_marketFaceName", "uint32_source", "string_camera_capture_templateinfo", "string_camera_capture_materialname", "string_ad_emo_jump_url", "string_ad_emo_desc_str", "msg_zplan_sticker", "bytes_original_image_md5_new"}, new Object[]{0, 0, 0, 0, "", "", byteStringMicro, 0, "", "", "", "", 0, "", "", "", "", null, byteStringMicro}, NotOnlineImageExtPb$ResvAttr.class);
    }

    public NotOnlineImageExtPb$ResvAttr() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_text_summary = PBField.initBytes(byteStringMicro);
        this.uint32_emoji_from = PBField.initUInt32(0);
        this.string_emoji_source = PBField.initString("");
        this.string_emoji_webUrl = PBField.initString("");
        this.string_emoji_iconUrl = PBField.initString("");
        this.string_emoji_marketFaceName = PBField.initString("");
        this.uint32_source = PBField.initUInt32(0);
        this.string_camera_capture_templateinfo = PBField.initString("");
        this.string_camera_capture_materialname = PBField.initString("");
        this.string_ad_emo_jump_url = PBField.initString("");
        this.string_ad_emo_desc_str = PBField.initString("");
        this.msg_zplan_sticker = new NotOnlineImageExtPb$ZPlanStickerMessageInfo();
        this.bytes_original_image_md5_new = PBField.initBytes(byteStringMicro);
    }
}
