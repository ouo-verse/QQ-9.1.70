package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class videoFile$ResvAttr extends MessageMicro<videoFile$ResvAttr> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_animoji_modelId;
    public final PBBytesField bytes_camera_templateName;
    public final PBBytesField bytes_camera_templateid;
    public final PBBytesField bytes_dynamic_text;
    public final PBBytesField bytes_hotvideo_icon;
    public final PBBytesField bytes_hotvideo_icon_sub;
    public final PBBytesField bytes_hotvideo_title;
    public final PBBytesField bytes_hotvideo_url;
    public final PBBytesField bytes_original_video_md5;
    public final PBBytesField bytes_shortVideoId;
    public final PBUInt32Field uint32_embed_video;
    public final PBUInt32Field uint32_long_video_kandian_type;
    public final PBUInt32Field uint32_msg_tail_type;
    public final PBUInt32Field uint32_red_envelope_type;
    public final PBUInt32Field uint32_source;
    public final PBUInt32Field uint32_source_codec_format;
    public final PBUInt32Field uint32_special_video_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56, 64, 74, 82, 88, 96, 106, 114, 120, 128, 138}, new String[]{"bytes_hotvideo_icon", "bytes_hotvideo_title", "bytes_hotvideo_url", "bytes_hotvideo_icon_sub", "uint32_special_video_type", "bytes_dynamic_text", "uint32_msg_tail_type", "uint32_red_envelope_type", "bytes_shortVideoId", "bytes_animoji_modelId", "uint32_long_video_kandian_type", "uint32_source", "bytes_camera_templateid", "bytes_camera_templateName", "uint32_embed_video", "uint32_source_codec_format", "bytes_original_video_md5"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro}, videoFile$ResvAttr.class);
    }

    public videoFile$ResvAttr() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_hotvideo_icon = PBField.initBytes(byteStringMicro);
        this.bytes_hotvideo_title = PBField.initBytes(byteStringMicro);
        this.bytes_hotvideo_url = PBField.initBytes(byteStringMicro);
        this.bytes_hotvideo_icon_sub = PBField.initBytes(byteStringMicro);
        this.uint32_special_video_type = PBField.initUInt32(0);
        this.bytes_dynamic_text = PBField.initBytes(byteStringMicro);
        this.uint32_msg_tail_type = PBField.initUInt32(0);
        this.uint32_red_envelope_type = PBField.initUInt32(0);
        this.bytes_shortVideoId = PBField.initBytes(byteStringMicro);
        this.bytes_animoji_modelId = PBField.initBytes(byteStringMicro);
        this.uint32_long_video_kandian_type = PBField.initUInt32(0);
        this.uint32_source = PBField.initUInt32(0);
        this.bytes_camera_templateid = PBField.initBytes(byteStringMicro);
        this.bytes_camera_templateName = PBField.initBytes(byteStringMicro);
        this.uint32_embed_video = PBField.initUInt32(0);
        this.uint32_source_codec_format = PBField.initUInt32(0);
        this.bytes_original_video_md5 = PBField.initBytes(byteStringMicro);
    }
}
