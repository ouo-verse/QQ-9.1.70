package tencent.gdt;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cps_info {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CpsCacheInfo extends MessageMicro<CpsCacheInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"trace_id", "kol_id", ShortVideoConstants.MEDIA_INFO, "pcg_media_trace_infos", "product_share_info"}, new Object[]{"", 0L, null, null, null}, CpsCacheInfo.class);
        public final PBStringField trace_id = PBField.initString("");
        public final PBUInt64Field kol_id = PBField.initUInt64(0);
        public MediaInfo media_info = new MediaInfo();
        public final PBRepeatMessageField<PcgMediaTraceInfo> pcg_media_trace_infos = PBField.initRepeatMessage(PcgMediaTraceInfo.class);
        public final PBRepeatMessageField<ProductShareInfo> product_share_info = PBField.initRepeatMessage(ProductShareInfo.class);

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class MediaInfo extends MessageMicro<MediaInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"trace_id", "user_id"}, new Object[]{"", ""}, MediaInfo.class);
            public final PBStringField trace_id = PBField.initString("");
            public final PBStringField user_id = PBField.initString("");
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CpsChanTagInfo extends MessageMicro<CpsChanTagInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "trace_id", "is_distribution"}, new Object[]{0L, "", Boolean.FALSE}, CpsChanTagInfo.class);
        public final PBUInt64Field product_id = PBField.initUInt64(0);
        public final PBStringField trace_id = PBField.initString("");
        public final PBBoolField is_distribution = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PcgMediaTraceInfo extends MessageMicro<PcgMediaTraceInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74, 82}, new String[]{"timestamp", "media_type", ReportDataBuilder.KEY_PRODUCT_ID, "scene", "content_id", "trace_id", "buyer_id", "seller_id", "ext_info", "seller_grade"}, new Object[]{0L, 0, 0L, 0, "", "", "", "", "", ""}, PcgMediaTraceInfo.class);
        public final PBUInt64Field timestamp = PBField.initUInt64(0);
        public final PBInt32Field media_type = PBField.initInt32(0);
        public final PBUInt64Field product_id = PBField.initUInt64(0);
        public final PBInt32Field scene = PBField.initInt32(0);
        public final PBStringField content_id = PBField.initString("");
        public final PBStringField trace_id = PBField.initString("");
        public final PBStringField buyer_id = PBField.initString("");
        public final PBStringField seller_id = PBField.initString("");
        public final PBStringField ext_info = PBField.initString("");
        public final PBStringField seller_grade = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ProductShareInfo extends MessageMicro<ProductShareInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "share_rate"}, new Object[]{0L, 0}, ProductShareInfo.class);
        public final PBUInt64Field product_id = PBField.initUInt64(0);
        public final PBUInt32Field share_rate = PBField.initUInt32(0);
    }

    cps_info() {
    }
}
