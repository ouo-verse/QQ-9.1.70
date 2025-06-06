package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class experiment_v2 {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ExternalExpInfo extends MessageMicro<ExternalExpInfo> {
        public static final int TRAFFIC_TYPE_ADNETWORK = 7;
        public static final int TRAFFIC_TYPE_BROWSER = 5;
        public static final int TRAFFIC_TYPE_HONGXIU = 10;
        public static final int TRAFFIC_TYPE_KANDIAN = 15;
        public static final int TRAFFIC_TYPE_KMUSIC = 2;
        public static final int TRAFFIC_TYPE_KUAIBAO = 14;
        public static final int TRAFFIC_TYPE_KUOLIE = 12;
        public static final int TRAFFIC_TYPE_NEWS = 3;
        public static final int TRAFFIC_TYPE_QQMINIPROGRAM = 16;
        public static final int TRAFFIC_TYPE_QQREAD = 8;
        public static final int TRAFFIC_TYPE_QQWEISHI = 11;
        public static final int TRAFFIC_TYPE_UNKOWN = 0;
        public static final int TRAFFIC_TYPE_VIDEO = 4;
        public static final int TRAFFIC_TYPE_WATERMARK_CAMERA = 13;
        public static final int TRAFFIC_TYPE_WESEE = 6;
        public static final int TRAFFIC_TYPE_WIFI = 9;
        public static final int TRAFFIC_TYPE_XX_APP = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "exp_id"}, new Object[]{0, ""}, ExternalExpInfo.class);
        public final PBEnumField type = PBField.initEnum(0);
        public final PBRepeatField<String> exp_id = PBField.initRepeat(PBStringField.__repeatHelper__);
    }

    experiment_v2() {
    }
}
