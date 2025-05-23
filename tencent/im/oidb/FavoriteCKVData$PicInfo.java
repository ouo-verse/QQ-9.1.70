package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FavoriteCKVData$PicInfo extends MessageMicro<FavoriteCKVData$PicInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5;
    public final PBBytesField bytes_name;
    public final PBBytesField bytes_note;
    public final PBBytesField bytes_pic_id;
    public final PBBytesField bytes_sha1;
    public final PBBytesField bytes_uri;
    public FavoriteCKVData$Author msg_owner;
    public final PBUInt32Field uint32_height;
    public final PBUInt32Field uint32_size;
    public final PBUInt32Field uint32_type;
    public final PBUInt32Field uint32_width;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64, 72, 82, 90}, new String[]{"bytes_uri", "bytes_md5", "bytes_sha1", "bytes_name", "bytes_note", "uint32_width", "uint32_height", "uint32_size", "uint32_type", "msg_owner", "bytes_pic_id"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, null, byteStringMicro}, FavoriteCKVData$PicInfo.class);
    }

    public FavoriteCKVData$PicInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_uri = PBField.initBytes(byteStringMicro);
        this.bytes_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_sha1 = PBField.initBytes(byteStringMicro);
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.bytes_note = PBField.initBytes(byteStringMicro);
        this.uint32_width = PBField.initUInt32(0);
        this.uint32_height = PBField.initUInt32(0);
        this.uint32_size = PBField.initUInt32(0);
        this.uint32_type = PBField.initUInt32(0);
        this.msg_owner = new FavoriteCKVData$Author();
        this.bytes_pic_id = PBField.initBytes(byteStringMicro);
    }
}
