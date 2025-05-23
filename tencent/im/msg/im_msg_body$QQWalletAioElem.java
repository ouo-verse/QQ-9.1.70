package tencent.im.msg;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$QQWalletAioElem extends MessageMicro<im_msg_body$QQWalletAioElem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_actions_priority;
    public final PBBytesField bytes_aio_image_left;
    public final PBBytesField bytes_aio_image_right;
    public final PBBytesField bytes_blackstripe;
    public final PBBytesField bytes_cft_image;
    public final PBBytesField bytes_content;
    public final PBBytesField bytes_iconurl;
    public final PBBytesField bytes_jump_url;
    public final PBBytesField bytes_linkurl;
    public final PBBytesField bytes_native_android;
    public final PBBytesField bytes_native_ios;
    public final PBBytesField bytes_notice;
    public final PBBytesField bytes_pb_reserve;
    public final PBBytesField bytes_subtitle;
    public final PBBytesField bytes_title;
    public final PBUInt32Field uint32_content_bgcolor;
    public final PBUInt32Field uint32_content_color;
    public final PBUInt32Field uint32_subtitle_color;
    public final PBUInt32Field uint32_title_color;
    public final PBUInt32Field uint32_background = PBField.initUInt32(0);
    public final PBUInt32Field uint32_icon = PBField.initUInt32(0);

    static {
        String[] strArr = {"uint32_background", "uint32_icon", "bytes_title", "bytes_subtitle", MessageForUniteGrayTip.KEY_BYTES_CONTENT, "bytes_linkurl", "bytes_blackstripe", "bytes_notice", "uint32_title_color", "uint32_subtitle_color", "bytes_actions_priority", "bytes_jump_url", "bytes_native_ios", "bytes_native_android", "bytes_iconurl", "uint32_content_color", "uint32_content_bgcolor", "bytes_aio_image_left", "bytes_aio_image_right", "bytes_cft_image", "bytes_pb_reserve"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 72, 80, 90, 98, 106, 114, 122, 128, 136, 146, 154, 162, 170}, strArr, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, im_msg_body$QQWalletAioElem.class);
    }

    public im_msg_body$QQWalletAioElem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.bytes_subtitle = PBField.initBytes(byteStringMicro);
        this.bytes_content = PBField.initBytes(byteStringMicro);
        this.bytes_linkurl = PBField.initBytes(byteStringMicro);
        this.bytes_blackstripe = PBField.initBytes(byteStringMicro);
        this.bytes_notice = PBField.initBytes(byteStringMicro);
        this.uint32_title_color = PBField.initUInt32(0);
        this.uint32_subtitle_color = PBField.initUInt32(0);
        this.bytes_actions_priority = PBField.initBytes(byteStringMicro);
        this.bytes_jump_url = PBField.initBytes(byteStringMicro);
        this.bytes_native_ios = PBField.initBytes(byteStringMicro);
        this.bytes_native_android = PBField.initBytes(byteStringMicro);
        this.bytes_iconurl = PBField.initBytes(byteStringMicro);
        this.uint32_content_color = PBField.initUInt32(0);
        this.uint32_content_bgcolor = PBField.initUInt32(0);
        this.bytes_aio_image_left = PBField.initBytes(byteStringMicro);
        this.bytes_aio_image_right = PBField.initBytes(byteStringMicro);
        this.bytes_cft_image = PBField.initBytes(byteStringMicro);
        this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
    }
}
