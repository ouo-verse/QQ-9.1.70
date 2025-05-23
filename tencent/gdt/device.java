package tencent.gdt;

import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class device {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Device extends MessageMicro<Device> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Device.class);

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class IdInfo extends MessageMicro<IdInfo> {
            public static final int DEVICE_ID = 1;
            public static final int DEVICE_ID_0 = 2;
            public static final int DEVICE_ID_1 = 4;
            public static final int IMEI = 8;
            public static final int IMEI_0 = 16;
            public static final int IMEI_1 = 32;
            public static final int MEID = 64;
            public static final int MEID_0 = 128;
            public static final int MEID_1 = 256;
            public static final int SUBSCRIBER_ID = 512;
            public static final int SUBSCRIBER_ID_0 = 1024;
            public static final int SUBSCRIBER_ID_1 = 2048;
            public static final int UNKNOWN = 0;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"device_id", MimeHelper.IMAGE_SUBTYPE_BITMAP}, new Object[]{"", 0}, IdInfo.class);
            public final PBStringField device_id = PBField.initString("");
            public final PBUInt32Field bitmap = PBField.initUInt32(0);
        }
    }

    device() {
    }
}
