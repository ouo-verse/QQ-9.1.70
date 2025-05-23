package tencent.im.ilive.photo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NowLiveGallary$RspBody extends MessageMicro<NowLiveGallary$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"errCode", "photo_info_list"}, new Object[]{0, null}, NowLiveGallary$RspBody.class);
    public final PBUInt32Field errCode = PBField.initUInt32(0);
    public final PBRepeatMessageField<PhotoInfo> photo_info_list = PBField.initRepeatMessage(PhotoInfo.class);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PhotoInfo extends MessageMicro<PhotoInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField cover;
        public final PBUInt64Field timestamp;
        public final PBBytesField video;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"video", "cover", "timestamp"}, new Object[]{byteStringMicro, byteStringMicro, 0L}, PhotoInfo.class);
        }

        public PhotoInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.video = PBField.initBytes(byteStringMicro);
            this.cover = PBField.initBytes(byteStringMicro);
            this.timestamp = PBField.initUInt64(0L);
        }
    }
}
