package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class adSchedule$App extends MessageMicro<adSchedule$App> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"id", "pkg_name", "name", "download_link"}, new Object[]{"", "", "", ""}, adSchedule$App.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f435896id = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField download_link = PBField.initString("");
}
