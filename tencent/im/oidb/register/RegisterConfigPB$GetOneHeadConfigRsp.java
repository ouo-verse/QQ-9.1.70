package tencent.im.oidb.register;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* loaded from: classes29.dex */
public final class RegisterConfigPB$GetOneHeadConfigRsp extends MessageMicro<RegisterConfigPB$GetOneHeadConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", DownloadInfo.spKey_Config}, new Object[]{0, null}, RegisterConfigPB$GetOneHeadConfigRsp.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public RegisterConfigPB$HeadConfig config = new MessageMicro<RegisterConfigPB$HeadConfig>() { // from class: tencent.im.oidb.register.RegisterConfigPB$HeadConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 45, 50, 58, 66, 72, 80}, new String[]{"id", "name", "gender", "default_url", "mask_rate", "in_bounds_clipper", "out_bounds_clipper", "event", "in_bounds_id", "sort_weight"}, new Object[]{0, "", 0, "", Float.valueOf(0.0f), null, null, null, 0, 0}, RegisterConfigPB$HeadConfig.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBInt32Field f436027id = PBField.initInt32(0);
        public final PBStringField name = PBField.initString("");
        public final PBInt32Field gender = PBField.initInt32(0);
        public final PBStringField default_url = PBField.initString("");
        public final PBFloatField mask_rate = PBField.initFloat(0.0f);
        public RegisterConfigPB$Clipper in_bounds_clipper = new MessageMicro<RegisterConfigPB$Clipper>() { // from class: tencent.im.oidb.register.RegisterConfigPB$Clipper
            static final MessageMicro.FieldMap __fieldMap__;

            /* renamed from: x, reason: collision with root package name */
            public final PBFloatField f436025x = PBField.initFloat(0.0f);

            /* renamed from: y, reason: collision with root package name */
            public final PBFloatField f436026y = PBField.initFloat(0.0f);
            public final PBFloatField width = PBField.initFloat(0.0f);
            public final PBFloatField height = PBField.initFloat(0.0f);

            static {
                String[] strArr = {HippyTKDListViewAdapter.X, "y", "width", "height"};
                Float valueOf = Float.valueOf(0.0f);
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 29, 37}, strArr, new Object[]{valueOf, valueOf, valueOf, valueOf}, RegisterConfigPB$Clipper.class);
            }
        };
        public RegisterConfigPB$Clipper out_bounds_clipper = new MessageMicro<RegisterConfigPB$Clipper>() { // from class: tencent.im.oidb.register.RegisterConfigPB$Clipper
            static final MessageMicro.FieldMap __fieldMap__;

            /* renamed from: x, reason: collision with root package name */
            public final PBFloatField f436025x = PBField.initFloat(0.0f);

            /* renamed from: y, reason: collision with root package name */
            public final PBFloatField f436026y = PBField.initFloat(0.0f);
            public final PBFloatField width = PBField.initFloat(0.0f);
            public final PBFloatField height = PBField.initFloat(0.0f);

            static {
                String[] strArr = {HippyTKDListViewAdapter.X, "y", "width", "height"};
                Float valueOf = Float.valueOf(0.0f);
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 29, 37}, strArr, new Object[]{valueOf, valueOf, valueOf, valueOf}, RegisterConfigPB$Clipper.class);
            }
        };
        public RegisterConfigPB$Event event = new MessageMicro<RegisterConfigPB$Event>() { // from class: tencent.im.oidb.register.RegisterConfigPB$Event
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"tag", "info"}, new Object[]{0L, ""}, RegisterConfigPB$Event.class);
            public final PBUInt64Field tag = PBField.initUInt64(0);
            public final PBStringField info = PBField.initString("");
        };
        public final PBInt32Field in_bounds_id = PBField.initInt32(0);
        public final PBInt32Field sort_weight = PBField.initInt32(0);
    };
}
