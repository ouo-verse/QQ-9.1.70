package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_im_msg_body$NotOnlineImage extends MessageMicro<nt_im_msg_body$NotOnlineImage> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field biz_type;
    public final PBBytesField bytes_pb_reserve;
    public final PBBytesField download_path;
    public final PBUInt32Field file_len;
    public final PBBytesField file_path;
    public final PBBytesField flag;
    public final PBUInt32Field img_type;
    public final PBUInt32Field index;
    public final PBBoolField old_pic_md5;
    public final PBBytesField old_ver_send_file;
    public final PBBytesField op_face_buf;
    public final PBUInt32Field original;
    public final PBUInt32Field pic_height;
    public final PBBytesField pic_md5;
    public final PBUInt32Field pic_width;
    public final PBBytesField previews_image;
    public final PBBytesField res_id;
    public final PBUInt32Field result;
    public final PBStringField str_400_url;
    public final PBStringField str_big_url;
    public final PBStringField str_orig_url;
    public final PBStringField str_thumb_url;
    public final PBUInt32Field uint32_400_height;
    public final PBUInt32Field uint32_400_width;
    public final PBUInt32Field uint32_download_len;
    public final PBUInt32Field uint32_file_id;
    public final PBUInt32Field uint32_show_len;
    public final PBUInt32Field uint32_thumb_height;
    public final PBUInt32Field uint32_thumb_width;

    static {
        String[] strArr = {"file_path", "file_len", QQWinkConstants.EDITOR_LOCAL_TEMPLATE_PATH, "old_ver_send_file", "img_type", "previews_image", "pic_md5", "pic_height", "pic_width", IPreloadServiceProxy.KEY_RESID, "flag", "str_thumb_url", "original", "str_big_url", "str_orig_url", "biz_type", "result", "index", "op_face_buf", "old_pic_md5", "uint32_thumb_width", "uint32_thumb_height", "uint32_file_id", "uint32_show_len", "uint32_download_len", "str_400_url", "uint32_400_width", "uint32_400_height", "bytes_pb_reserve"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 58, 64, 72, 82, 90, 98, 104, 114, 122, 128, 136, 144, 154, 160, 168, 176, 184, 192, 200, 210, 216, 224, 234}, strArr, new Object[]{byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, "", 0, "", "", 0, 0, 0, byteStringMicro, Boolean.FALSE, 0, 0, 0, 0, 0, "", 0, 0, byteStringMicro}, nt_im_msg_body$NotOnlineImage.class);
    }

    public nt_im_msg_body$NotOnlineImage() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.file_path = PBField.initBytes(byteStringMicro);
        this.file_len = PBField.initUInt32(0);
        this.download_path = PBField.initBytes(byteStringMicro);
        this.old_ver_send_file = PBField.initBytes(byteStringMicro);
        this.img_type = PBField.initUInt32(0);
        this.previews_image = PBField.initBytes(byteStringMicro);
        this.pic_md5 = PBField.initBytes(byteStringMicro);
        this.pic_height = PBField.initUInt32(0);
        this.pic_width = PBField.initUInt32(0);
        this.res_id = PBField.initBytes(byteStringMicro);
        this.flag = PBField.initBytes(byteStringMicro);
        this.str_thumb_url = PBField.initString("");
        this.original = PBField.initUInt32(0);
        this.str_big_url = PBField.initString("");
        this.str_orig_url = PBField.initString("");
        this.biz_type = PBField.initUInt32(0);
        this.result = PBField.initUInt32(0);
        this.index = PBField.initUInt32(0);
        this.op_face_buf = PBField.initBytes(byteStringMicro);
        this.old_pic_md5 = PBField.initBool(false);
        this.uint32_thumb_width = PBField.initUInt32(0);
        this.uint32_thumb_height = PBField.initUInt32(0);
        this.uint32_file_id = PBField.initUInt32(0);
        this.uint32_show_len = PBField.initUInt32(0);
        this.uint32_download_len = PBField.initUInt32(0);
        this.str_400_url = PBField.initString("");
        this.uint32_400_width = PBField.initUInt32(0);
        this.uint32_400_height = PBField.initUInt32(0);
        this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
    }
}
