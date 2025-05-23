package rw1;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.richmedia.provider.h;
import com.tencent.qqnt.aio.adapter.richmedia.provider.i;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;
import rw1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u000e*\u0001R\u0018\u0000 ]2\u00020\u0001:\u0001^B=\b\u0016\u0012\b\u0010V\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010W\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010X\u001a\u00020\u0013\u0012\u0006\u0010Y\u001a\u00020\u0003\u0012\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a2\u0006\u0004\b[\u0010\\J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H\u0002JJ\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J8\u0010 \u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\u0011H\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010%\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J!\u0010'\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0013H\u0016J\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020\u0005J\u0016\u0010.\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H\u0014J\u0006\u0010/\u001a\u00020\u0005J \u00100\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\"\u00103\u001a\u0004\u0018\u0001022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u0013H\u0016J \u00104\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u00106\u001a\u00020\u0005H\u0016R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R&\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030;j\b\u0012\u0004\u0012\u00020\u0003`<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R2\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130?j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0013`@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010Q\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010=R\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006_"}, d2 = {"Lrw1/b;", "Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "localMsgRecordList", "", "r6", TabPreloadItem.TAB_NAME_MESSAGE, "t6", "msgRecordList", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "h6", "Lcom/tencent/mobileqq/data/ChatMessage;", "g6", QQPermissionConstants.Permission.AUIDO_GROUP, "u6", "msg", "", "id", "", "subId", "type", "downType", "result", "", "resultStr", "", "isPart", "e6", "progress", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "f6", "msgId", "j6", "p6", "q6", "m6", "k6", "l6", "(JI)Ljava/lang/Integer;", "loadType", "D", ICustomDataEditor.STRING_PARAM_6, "i6", "tempDataList", "E3", ICustomDataEditor.NUMBER_PARAM_6, "y", "curType", "Landroid/content/Intent;", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "f", "destory", "Landroid/os/Handler;", "Y", "Landroid/os/Handler;", "mainHandler", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Z", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a0", "Ljava/util/HashMap;", "downloadInfo", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "b0", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "c0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "curMsgRecord", "d0", "J", "minMsgId", "e0", "minMsgSeq", "f0", "isInited", "rw1/b$c", "g0", "Lrw1/b$c;", "msgListener", "myUin", "friendUin", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "msgRecord", "aioRichMediaList", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/util/List;)V", "h0", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends AIOImageProviderService {

    /* renamed from: Y, reason: from kotlin metadata */
    private final Handler mainHandler;

    /* renamed from: Z, reason: from kotlin metadata */
    private ArrayList<MsgRecord> msgRecordList;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, Integer> downloadInfo;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private Contact contact;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private MsgRecord curMsgRecord;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private long minMsgId;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private long minMsgSeq;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean isInited;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private c msgListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"rw1/b$b", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "", "path", "", CoverDBCacheData.URLS, "domain", "", "b", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "", "result", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rw1.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11165b implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MsgRecord f432600a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f432601b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f432602c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f432603d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f432604e;

        C11165b(MsgRecord msgRecord, int i3, b bVar, long j3, int i16) {
            this.f432600a = msgRecord;
            this.f432601b = i3;
            this.f432602c = bVar;
            this.f432603d = j3;
            this.f432604e = i16;
        }

        @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.i
        public void a(int result, String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            MsgRecord msgRecord = this.f432600a;
            QLog.i("AIOImageProviderServiceGuild", 1, "[onGetImageResult] msgSeq: " + msgRecord.msgSeq + ", type: " + this.f432601b + ", msgId: " + msgRecord.msgId + ", path: " + path);
            this.f432602c.e6(this.f432600a, this.f432603d, this.f432604e, this.f432601b, -1, result, path, false);
        }

        @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.i
        public void b(String path, String[] urls, String domain) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(urls, "urls");
            Intrinsics.checkNotNullParameter(domain, "domain");
            MsgRecord msgRecord = this.f432600a;
            QLog.i("AIOImageProviderServiceGuild", 1, "[onGetVideoUrl] msgSeq: " + msgRecord.msgSeq + ", type: " + this.f432601b + ", msgId: " + msgRecord.msgId + ", urls: " + urls.length);
            if (this.f432602c.x5() != null) {
                QQAppInterface qqAppInterface = this.f432602c.x5();
                Intrinsics.checkNotNullExpressionValue(qqAppInterface, "qqAppInterface");
                ChatMessage a16 = k.a(qqAppInterface, this.f432600a);
                this.f432602c.j0(this.f432603d, this.f432604e, this.f432601b, path, urls, domain, a16 instanceof MessageForShortVideo ? (MessageForShortVideo) a16 : null, 67, null);
                return;
            }
            QLog.i("AIOImageProviderServiceGuild", 1, "[onGetVideoUrl] qqAppInterface is NULL!");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"rw1/b$c", "Lcom/tencent/qqnt/msg/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "onRichMediaProgerssUpdate", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c extends com.tencent.qqnt.msg.i {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(FileTransNotifyInfo fileTransNotifyInfo, b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (fileTransNotifyInfo != null) {
                this$0.p6(fileTransNotifyInfo);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(FileTransNotifyInfo fileTransNotifyInfo, b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (fileTransNotifyInfo != null) {
                this$0.q6(fileTransNotifyInfo);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(final FileTransNotifyInfo notifyInfo) {
            Handler handler = b.this.mainHandler;
            final b bVar = b.this;
            handler.post(new Runnable() { // from class: rw1.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.c.c(FileTransNotifyInfo.this, bVar);
                }
            });
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaProgerssUpdate(final FileTransNotifyInfo notifyInfo) {
            Handler handler = b.this.mainHandler;
            final b bVar = b.this;
            handler.post(new Runnable() { // from class: rw1.d
                @Override // java.lang.Runnable
                public final void run() {
                    b.c.d(FileTransNotifyInfo.this, bVar);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(String str, String str2, int i3, MsgRecord msgRecord, List<MsgRecord> list) {
        super(str, str2, i3, null);
        Iterator<MsgRecord> it;
        w e16;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.msgRecordList = new ArrayList<>();
        this.downloadInfo = new HashMap<>();
        this.msgListener = new c();
        this.curMsgRecord = msgRecord;
        if (list != null) {
            List<MsgRecord> list2 = list;
            if (!list2.isEmpty()) {
                this.msgRecordList.addAll(list2);
                it = this.msgRecordList.iterator();
                while (it.hasNext()) {
                    MsgRecord msg2 = it.next();
                    QQAppInterface qqAppInterface = x5();
                    Intrinsics.checkNotNullExpressionValue(qqAppInterface, "qqAppInterface");
                    Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                    ChatMessage a16 = k.a(qqAppInterface, msg2);
                    if (a16 != null) {
                        this.E.add(a16);
                    }
                    e eVar = e.f432610a;
                    QQAppInterface qqAppInterface2 = x5();
                    Intrinsics.checkNotNullExpressionValue(qqAppInterface2, "qqAppInterface");
                    List c16 = e.c(eVar, qqAppInterface2, msg2, null, 4, null);
                    if (c16 != null) {
                        this.F.addAll(c16);
                    }
                }
                this.contact = new Contact(msgRecord.chatType, msgRecord.peerUid, msgRecord.guildId);
                this.minMsgId = msgRecord.msgId;
                this.minMsgSeq = msgRecord.msgSeq;
                t6(this.msgRecordList);
                QLog.i("AIOImageProviderServiceGuild", 1, "curMsgRecord: " + this.curMsgRecord + ", minMsgId: " + this.minMsgId + ", minMsgSeq: " + this.minMsgSeq + ", msgRecordList: " + this.msgRecordList.size() + ", dataList: " + this.F.size());
                e16 = com.tencent.qqnt.msg.f.e();
                if (e16 == null) {
                    e16.addMsgListener(this.msgListener);
                    return;
                }
                return;
            }
        }
        this.msgRecordList.add(msgRecord);
        it = this.msgRecordList.iterator();
        while (it.hasNext()) {
        }
        this.contact = new Contact(msgRecord.chatType, msgRecord.peerUid, msgRecord.guildId);
        this.minMsgId = msgRecord.msgId;
        this.minMsgSeq = msgRecord.msgSeq;
        t6(this.msgRecordList);
        QLog.i("AIOImageProviderServiceGuild", 1, "curMsgRecord: " + this.curMsgRecord + ", minMsgId: " + this.minMsgId + ", minMsgSeq: " + this.minMsgSeq + ", msgRecordList: " + this.msgRecordList.size() + ", dataList: " + this.F.size());
        e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
        }
    }

    private final List<ChatMessage> g6(List<MsgRecord> msgRecordList) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (MsgRecord msgRecord : msgRecordList) {
            u6(msgRecord);
            QQAppInterface qqAppInterface = x5();
            Intrinsics.checkNotNullExpressionValue(qqAppInterface, "qqAppInterface");
            ChatMessage a16 = k.a(qqAppInterface, msgRecord);
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderServiceGuild", 2, "convertMsgToMediaData total size " + this.F.size() + ", cost " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return arrayList;
    }

    private final List<AIORichMediaData> h6(List<MsgRecord> msgRecordList) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (MsgRecord msgRecord : msgRecordList) {
            u6(msgRecord);
            e eVar = e.f432610a;
            QQAppInterface qqAppInterface = x5();
            Intrinsics.checkNotNullExpressionValue(qqAppInterface, "qqAppInterface");
            List c16 = e.c(eVar, qqAppInterface, msgRecord, null, 4, null);
            if (c16 != null) {
                arrayList.addAll(c16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderServiceGuild", 2, "convertMsgToMediaData total dataListSize " + arrayList.size() + ", cost " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return arrayList;
    }

    private final MsgRecord j6(long msgId) {
        synchronized (this.msgRecordList) {
            Iterator<MsgRecord> it = this.msgRecordList.iterator();
            while (it.hasNext()) {
                MsgRecord next = it.next();
                if (next.msgId == msgId) {
                    return next;
                }
            }
            Unit unit = Unit.INSTANCE;
            return null;
        }
    }

    private final String k6(long id5, int subId) {
        return id5 + "_" + subId;
    }

    private final Integer l6(long id5, int subId) {
        if (!this.downloadInfo.containsKey(k6(id5, subId)) && QLog.isColorLevel()) {
            QLog.i("AIOImageProviderServiceGuild", 2, "[getDownloadType] msgId: " + id5 + ", subId: " + subId + ". Fail to get downloadType.");
        }
        return this.downloadInfo.get(k6(id5, subId));
    }

    private final int m6(MsgRecord msg2, FileTransNotifyInfo fileInfo) {
        ArrayList<MsgElement> arrayList = msg2.elements;
        if (arrayList != null && arrayList.size() > 0) {
            int size = msg2.elements.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (msg2.elements.get(i3).elementId == fileInfo.msgElementId) {
                    return i3;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o6(b this$0, long j3, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AIOImageProviderServiceGuild", 1, "getMsgsByTypeFilters minMsgId: " + this$0.minMsgId + ", minSeq: " + this$0.minMsgSeq + ", code: " + i3 + ", errMsg: " + str + ", cost " + (System.currentTimeMillis() - j3));
        this$0.t6(arrayList);
        this$0.r6(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p6(FileTransNotifyInfo fileInfo) {
        MsgRecord j65 = j6(fileInfo.msgId);
        if (j65 == null) {
            return;
        }
        int m65 = m6(j65, fileInfo);
        int i3 = fileInfo.fileErrCode == 0 ? 1 : 2;
        Integer l65 = l6(j65.msgId, m65);
        int intValue = l65 != null ? l65.intValue() : 0;
        this.downloadInfo.remove(k6(j65.msgId, (int) fileInfo.msgElementId));
        QLog.i("AIOImageProviderServiceGuild", 1, "[onRichMediaDownloadComplete] msgSeq: " + j65.msgSeq + ", type: " + intValue + ", msgId: " + j65.msgId + ", subId: " + m65 + ", fileInfo: " + fileInfo);
        e6(j65, j65.msgId, m65, intValue, fileInfo.fileDownType, i3, fileInfo.filePath, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q6(FileTransNotifyInfo fileInfo) {
        MsgRecord j65 = j6(fileInfo.msgId);
        if (j65 == null) {
            return;
        }
        int m65 = m6(j65, fileInfo);
        Integer l65 = l6(j65.msgId, m65);
        int intValue = l65 != null ? l65.intValue() : 0;
        long j3 = fileInfo.totalSize;
        long j16 = j3 > 0 ? (fileInfo.fileProgress * 10000) / j3 : 0L;
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOImageProviderServiceGuild", 4, "[onRichMediaDownloadProgressUpdate] msgSeq: " + j65.msgSeq + ", type: " + intValue + ", msgId: " + j65.msgId + ", subId: " + m65 + ", fileInfo: " + fileInfo + ", progress: " + j16);
        }
        f6(j65, j65.msgId, m65, intValue, j16, fileInfo);
    }

    private final void u6(MsgRecord record) {
        long j3 = record.msgSeq;
        if (j3 < this.J) {
            this.J = j3;
        }
        long j16 = record.timeStamp;
        if (j16 < this.L) {
            this.L = j16;
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService, com.tencent.mobileqq.activity.aio.photo.h
    public void A(long id5, int subId, int type) {
        MsgRecord j65 = j6(id5);
        if (j65 == null) {
            return;
        }
        h d16 = e.f432610a.d(j65);
        this.downloadInfo.remove(k6(id5, subId));
        if (d16 != null) {
            d16.a(j65, subId, type, null);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService, com.tencent.mobileqq.activity.aio.photo.h
    public void D(int loadType) {
        if (this.f179747d == null) {
            return;
        }
        QLog.i("AIOImageProviderServiceGuild", 1, "[loadMedias] + loadType: " + loadType);
        if (loadType != 0) {
            if (loadType == 1 && this.f179747d != null) {
                if (this.F.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    List<AIORichMediaData> dataList = this.F;
                    Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
                    synchronized (dataList) {
                        for (int i3 = 0; i3 < this.F.size(); i3++) {
                            AIORichMediaData data = this.F.get(i3);
                            if (!AIOImageProviderService.L5(data)) {
                                Intrinsics.checkNotNullExpressionValue(data, "data");
                                arrayList.add(data);
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    Object[] array = arrayList.toArray(new AIORichMediaData[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    this.f179747d.e5((AIORichMediaData[]) array, -1);
                    return;
                }
                i6();
                return;
            }
            return;
        }
        i6();
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService
    protected void E3(List<? extends AIORichMediaData> tempDataList) {
        Intrinsics.checkNotNullParameter(tempDataList, "tempDataList");
        com.tencent.mobileqq.activity.aio.photo.i iVar = this.f179747d;
        if (iVar != null) {
            Object[] array = tempDataList.toArray(new AIORichMediaData[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            iVar.e5((AIORichMediaData[]) array, -1);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService, com.tencent.mobileqq.activity.aio.photo.h.a, com.tencent.mobileqq.activity.aio.photo.h
    public void destory() {
        super.destory();
        this.downloadInfo.clear();
        this.msgRecordList.clear();
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.removeMsgListener(this.msgListener);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService, com.tencent.mobileqq.activity.aio.photo.h
    public void f(long id5) {
        ChatMessage m56;
        BaseActivity S5;
        boolean z16;
        MsgRecord j65 = j6(id5);
        if (j65 == null || (m56 = m5(id5)) == null || (S5 = S5("saveToWeiyun_MessageForPic")) == null) {
            return;
        }
        h d16 = e.f432610a.d(j65);
        if (d16 != null) {
            QQAppInterface qqAppInterface = x5();
            Intrinsics.checkNotNullExpressionValue(qqAppInterface, "qqAppInterface");
            z16 = d16.d(m56, j65, S5, qqAppInterface);
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        super.f(id5);
    }

    public final void n6() {
        final long currentTimeMillis = System.currentTimeMillis();
        ArrayList<MsgTypeFilter> arrayList = new ArrayList<>();
        arrayList.add(new MsgTypeFilter(2, new ArrayList()));
        arrayList.add(new MsgTypeFilter(7, new ArrayList()));
        arrayList.add(new MsgTypeFilter(3, new ArrayList()));
        arrayList.add(new MsgTypeFilter(2, new ArrayList()));
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgsByTypeFilters(this.contact, this.minMsgId, 60, true, arrayList, new IMsgOperateCallback() { // from class: rw1.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList2) {
                b.o6(b.this, currentTimeMillis, i3, str, arrayList2);
            }
        });
    }

    public final boolean s6() {
        boolean z16;
        boolean z17 = false;
        if (this.M < 60) {
            M5();
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.f179747d == null) {
            M5();
            z16 = false;
        }
        if (this.f179589f == null) {
            M5();
        } else {
            z17 = z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderServiceGuild", 2, "[preCheckLoadMedias] result: " + z17);
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService, com.tencent.mobileqq.activity.aio.photo.h
    public Intent u(long id5, int subId, int curType) {
        h d16;
        MsgRecord j65 = j6(id5);
        if (j65 == null || (d16 = e.f432610a.d(j65)) == null) {
            return null;
        }
        return d16.h(j65, subId, null, curType);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService, com.tencent.mobileqq.activity.aio.photo.h
    public void y(long id5, int subId, int type) {
        MsgRecord j65 = j6(id5);
        if (j65 == null) {
            return;
        }
        h d16 = e.f432610a.d(j65);
        C11165b c11165b = new C11165b(j65, type, this, id5, subId);
        this.downloadInfo.put(k6(id5, subId), Integer.valueOf(type));
        QLog.i("AIOImageProviderServiceGuild", 1, "[downloadMedia] msgSeq: " + j65.msgSeq + ", type: " + type + ", msgId: " + j65.msgId + ", subId: " + subId);
        if (d16 != null) {
            d16.g(j65, subId, type, null, c11165b);
        }
    }

    private final void f6(MsgRecord msg2, long id5, int subId, int type, long progress, FileTransNotifyInfo fileInfo) {
        h d16 = e.f432610a.d(msg2);
        notifyImageProgress(msg2.msgId, subId, d16 != null ? d16.f(msg2, type, false) : type, (int) progress, fileInfo.totalSize, true);
    }

    public final void i6() {
        this.H = true;
        if (!s6()) {
            this.H = false;
            return;
        }
        if (!this.isInited) {
            this.isInited = true;
            List<AIORichMediaData> dataList = this.F;
            Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
            if (true ^ dataList.isEmpty()) {
                List<AIORichMediaData> dataList2 = this.F;
                Intrinsics.checkNotNullExpressionValue(dataList2, "dataList");
                E3(dataList2);
            }
            this.H = false;
            return;
        }
        n6();
    }

    private final void t6(List<MsgRecord> msgList) {
        if (msgList != null) {
            for (MsgRecord msgRecord : msgList) {
                long j3 = this.minMsgSeq;
                long j16 = msgRecord.msgSeq;
                if (j3 > j16) {
                    this.minMsgSeq = j16;
                    this.minMsgId = msgRecord.msgId;
                }
            }
            QLog.i("AIOImageProviderServiceGuild", 1, "updateMinId new minMsgId: " + this.minMsgId + ", new minSeq: " + this.minMsgSeq + ", msgListSize: " + msgList.size());
        }
    }

    private final void r6(List<MsgRecord> localMsgRecordList) {
        try {
            try {
                if (localMsgRecordList != null) {
                    this.M = localMsgRecordList.size();
                    List<AIORichMediaData> h65 = h6(localMsgRecordList);
                    List<ChatMessage> g65 = g6(localMsgRecordList);
                    if (!h65.isEmpty()) {
                        synchronized (this.msgRecordList) {
                            this.msgRecordList.addAll(0, localMsgRecordList);
                        }
                        List<AIORichMediaData> dataList = this.F;
                        Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
                        synchronized (dataList) {
                            this.F.addAll(0, h65);
                        }
                        List<ChatMessage> messageList = this.E;
                        Intrinsics.checkNotNullExpressionValue(messageList, "messageList");
                        synchronized (messageList) {
                            this.E.addAll(0, g65);
                        }
                        E3(h65);
                    }
                    QLog.i("AIOImageProviderServiceGuild", 1, "[onMediaLoaded], msgRecordList.size: " + this.msgRecordList.size() + ", dataList.size: " + this.F.size());
                } else {
                    QLog.i("AIOImageProviderServiceGuild", 1, "[onMediaLoaded], msgRecordList is null!");
                    M5();
                }
            } catch (Exception e16) {
                QLog.i("AIOImageProviderServiceGuild", 1, "realLoadMedias exception = " + e16.getMessage());
            }
        } finally {
            this.H = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e6(MsgRecord msg2, long id5, int subId, int type, int downType, int result, String resultStr, boolean isPart) {
        int i3;
        boolean z16;
        h d16 = e.f432610a.d(msg2);
        if (d16 != null) {
            int f16 = d16.f(msg2, type, true);
            z16 = downType != -1 ? d16.e(type, downType) : true;
            i3 = f16;
        } else {
            i3 = type;
            z16 = true;
        }
        if (z16) {
            notifyImageResult(id5, subId, i3, result, resultStr, isPart);
            return;
        }
        QLog.i("AIOImageProviderServiceGuild", 1, "[checkTypeAndNotifyImageResult] canNotify = false, type: " + type + ", downType: " + downType + ", msgSeq: " + msg2.msgSeq + ", msgId: " + msg2.msgId);
    }
}
