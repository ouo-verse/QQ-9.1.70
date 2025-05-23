package ru3;

import android.content.Intent;
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
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u000e*\u0001L\u0018\u0000 W2\u00020\u0001:\u0001XB=\b\u0016\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010R\u001a\u00020\u0013\u0012\u0006\u0010S\u001a\u00020\u0003\u0012\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a2\u0006\u0004\bU\u0010VJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H\u0002JB\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J8\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010%\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J!\u0010&\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0006\u0010*\u001a\u00020\u0019J\u0006\u0010+\u001a\u00020\u0005J\u0016\u0010-\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H\u0014J\u0006\u0010.\u001a\u00020\u0005J \u0010/\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\"\u00102\u001a\u0004\u0018\u0001012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0013H\u0016J \u00103\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u00104\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u00105\u001a\u00020\u0005H\u0016R&\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000306j\b\u0012\u0004\u0012\u00020\u0003`78\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\"\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010K\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010;R\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006Y"}, d2 = {"Lru3/b;", "Lcom/tencent/mobileqq/activity/aio/photo/AIOImageProviderService;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "localMsgRecordList", "", "q6", TabPreloadItem.TAB_NAME_MESSAGE, ICustomDataEditor.STRING_PARAM_6, "msgRecordList", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "g6", "Lcom/tencent/mobileqq/data/ChatMessage;", "f6", QQPermissionConstants.Permission.AUIDO_GROUP, "t6", "msg", "", "id", "", "subId", "type", "result", "", "resultStr", "", "isPart", "d6", "progress", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "e6", "msgId", "i6", "o6", "p6", "l6", "j6", "k6", "(JI)Ljava/lang/Integer;", "loadType", "D", "r6", "h6", "tempDataList", "E3", "m6", "y", "curType", "Landroid/content/Intent;", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "f", "destory", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Y", "Ljava/util/ArrayList;", "Ljava/util/concurrent/ConcurrentHashMap;", "Z", "Ljava/util/concurrent/ConcurrentHashMap;", "downloadInfo", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "a0", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "b0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "curMsgRecord", "c0", "J", "minMsgId", "d0", "minMsgSeq", "e0", "isInited", "ru3/b$c", "f0", "Lru3/b$c;", "msgListener", "myUin", "friendUin", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "msgRecord", "aioRichMediaList", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/util/List;)V", "g0", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends AIOImageProviderService {

    /* renamed from: Y, reason: from kotlin metadata */
    private ArrayList<MsgRecord> msgRecordList;

    /* renamed from: Z, reason: from kotlin metadata */
    private ConcurrentHashMap<String, Integer> downloadInfo;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private Contact contact;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private MsgRecord curMsgRecord;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private long minMsgId;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private long minMsgSeq;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean isInited;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private c msgListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"ru3/b$b", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "", "path", "", CoverDBCacheData.URLS, "domain", "", "b", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "", "result", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ru3.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11163b implements com.tencent.qqnt.aio.adapter.richmedia.provider.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MsgRecord f432497a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f432498b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f432499c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f432500d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f432501e;

        C11163b(MsgRecord msgRecord, int i3, b bVar, long j3, int i16) {
            this.f432497a = msgRecord;
            this.f432498b = i3;
            this.f432499c = bVar;
            this.f432500d = j3;
            this.f432501e = i16;
        }

        @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.i
        public void a(int result, String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            MsgRecord msgRecord = this.f432497a;
            QLog.i("AIOImageProviderServiceNT", 1, "[onGetImageResult] msgSeq: " + msgRecord.msgSeq + ", type: " + this.f432498b + ", msgId: " + msgRecord.msgId + ", path: " + path);
            this.f432499c.d6(this.f432497a, this.f432500d, this.f432501e, this.f432498b, result, path, false);
        }

        @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.i
        public void b(String path, String[] urls, String domain) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(urls, "urls");
            Intrinsics.checkNotNullParameter(domain, "domain");
            MsgRecord msgRecord = this.f432497a;
            QLog.i("AIOImageProviderServiceNT", 1, "[onGetVideoUrl] msgSeq: " + msgRecord.msgSeq + ", type: " + this.f432498b + ", msgId: " + msgRecord.msgId + ", urls: " + urls.length);
            if (this.f432499c.x5() == null) {
                QLog.i("AIOImageProviderServiceNT", 1, "[onGetVideoUrl] qqAppInterface is NULL!");
                return;
            }
            IMsgConverterUtilsApi iMsgConverterUtilsApi = (IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class);
            QQAppInterface qqAppInterface = this.f432499c.x5();
            Intrinsics.checkNotNullExpressionValue(qqAppInterface, "qqAppInterface");
            ChatMessage convertToChatMessage = iMsgConverterUtilsApi.convertToChatMessage(qqAppInterface, this.f432497a);
            this.f432499c.j0(this.f432500d, this.f432501e, this.f432498b, path, urls, domain, convertToChatMessage instanceof MessageForShortVideo ? (MessageForShortVideo) convertToChatMessage : null, 67, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(String str, String str2, int i3, MsgRecord msgRecord, List<MsgRecord> list) {
        super(str, str2, i3, null);
        Iterator<MsgRecord> it;
        w e16;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        this.msgRecordList = new ArrayList<>();
        this.downloadInfo = new ConcurrentHashMap<>();
        this.msgListener = new c();
        this.curMsgRecord = msgRecord;
        if (list != null) {
            List<MsgRecord> list2 = list;
            if (!list2.isEmpty()) {
                this.msgRecordList.addAll(list2);
                it = this.msgRecordList.iterator();
                while (it.hasNext()) {
                    MsgRecord msg2 = it.next();
                    IMsgConverterUtilsApi iMsgConverterUtilsApi = (IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class);
                    QQAppInterface qqAppInterface = x5();
                    Intrinsics.checkNotNullExpressionValue(qqAppInterface, "qqAppInterface");
                    Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                    ChatMessage convertToChatMessage = iMsgConverterUtilsApi.convertToChatMessage(qqAppInterface, msg2);
                    if (convertToChatMessage != null) {
                        this.E.add(convertToChatMessage);
                    }
                    ru3.c cVar = ru3.c.f432503a;
                    QQAppInterface qqAppInterface2 = x5();
                    Intrinsics.checkNotNullExpressionValue(qqAppInterface2, "qqAppInterface");
                    List c16 = ru3.c.c(cVar, qqAppInterface2, msg2, null, null, 12, null);
                    if (c16 != null) {
                        this.F.addAll(c16);
                    }
                }
                this.contact = new Contact(msgRecord.chatType, msgRecord.peerUid, msgRecord.guildId);
                this.minMsgId = msgRecord.msgId;
                this.minMsgSeq = msgRecord.msgSeq;
                s6(this.msgRecordList);
                QLog.i("AIOImageProviderServiceNT", 1, "curMsgRecord: " + this.curMsgRecord.msgId + ", minMsgId: " + this.minMsgId + ", minMsgSeq: " + this.minMsgSeq + ", msgRecordList: " + this.msgRecordList.size() + ", dataList: " + this.F.size());
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
        s6(this.msgRecordList);
        QLog.i("AIOImageProviderServiceNT", 1, "curMsgRecord: " + this.curMsgRecord.msgId + ", minMsgId: " + this.minMsgId + ", minMsgSeq: " + this.minMsgSeq + ", msgRecordList: " + this.msgRecordList.size() + ", dataList: " + this.F.size());
        e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
        }
    }

    private final List<ChatMessage> f6(List<MsgRecord> msgRecordList) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (MsgRecord msgRecord : msgRecordList) {
            t6(msgRecord);
            IMsgConverterUtilsApi iMsgConverterUtilsApi = (IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class);
            QQAppInterface qqAppInterface = x5();
            Intrinsics.checkNotNullExpressionValue(qqAppInterface, "qqAppInterface");
            ChatMessage convertToChatMessage = iMsgConverterUtilsApi.convertToChatMessage(qqAppInterface, msgRecord);
            if (convertToChatMessage != null) {
                arrayList.add(convertToChatMessage);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderServiceNT", 2, "convertMsgToMediaData total size " + this.F.size() + ", cost " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return arrayList;
    }

    private final List<AIORichMediaData> g6(List<MsgRecord> msgRecordList) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (MsgRecord msgRecord : msgRecordList) {
            t6(msgRecord);
            ru3.c cVar = ru3.c.f432503a;
            QQAppInterface qqAppInterface = x5();
            Intrinsics.checkNotNullExpressionValue(qqAppInterface, "qqAppInterface");
            List c16 = ru3.c.c(cVar, qqAppInterface, msgRecord, null, null, 12, null);
            if (c16 != null) {
                arrayList.addAll(c16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOImageProviderServiceNT", 2, "convertMsgToMediaData total dataListSize " + arrayList.size() + ", cost " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return arrayList;
    }

    private final MsgRecord i6(long msgId) {
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

    private final String j6(long id5, int subId) {
        return id5 + "_" + subId;
    }

    private final Integer k6(long id5, int subId) {
        if (!this.downloadInfo.containsKey(j6(id5, subId)) && QLog.isColorLevel()) {
            QLog.i("AIOImageProviderServiceNT", 2, "[getDownloadType] msgId: " + id5 + ", subId: " + subId + ". Fail to get downloadType.");
        }
        return this.downloadInfo.get(j6(id5, subId));
    }

    private final int l6(MsgRecord msg2, FileTransNotifyInfo fileInfo) {
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
    public static final void n6(b this$0, long j3, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AIOImageProviderServiceNT", 1, "getMsgsByTypeFilters minMsgId: " + this$0.minMsgId + ", minSeq: " + this$0.minMsgSeq + ", code: " + i3 + ", errMsg: " + str + ", cost " + (System.currentTimeMillis() - j3));
        this$0.s6(arrayList);
        this$0.q6(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o6(FileTransNotifyInfo fileInfo) {
        MsgRecord i65 = i6(fileInfo.msgId);
        if (i65 == null) {
            return;
        }
        int l65 = l6(i65, fileInfo);
        int i3 = fileInfo.fileErrCode == 0 ? 1 : 2;
        Integer k65 = k6(i65.msgId, l65);
        int intValue = k65 != null ? k65.intValue() : 0;
        this.downloadInfo.remove(j6(i65.msgId, (int) fileInfo.msgElementId));
        QLog.i("AIOImageProviderServiceNT", 1, "[onRichMediaDownloadComplete] msgSeq: " + i65.msgSeq + ", type: " + intValue + ", msgId: " + i65.msgId + ", subId: " + l65 + ", fileInfo: " + fileInfo);
        d6(i65, i65.msgId, l65, intValue, i3, fileInfo.filePath, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p6(FileTransNotifyInfo fileInfo) {
        MsgRecord i65 = i6(fileInfo.msgId);
        if (i65 == null) {
            return;
        }
        int l65 = l6(i65, fileInfo);
        Integer k65 = k6(i65.msgId, l65);
        int intValue = k65 != null ? k65.intValue() : 0;
        long j3 = fileInfo.totalSize;
        long j16 = j3 > 0 ? (fileInfo.fileProgress * 10000) / j3 : 0L;
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOImageProviderServiceNT", 4, "[onRichMediaDownloadProgressUpdate] msgSeq: " + i65.msgSeq + ", type: " + intValue + ", msgId: " + i65.msgId + ", subId: " + l65 + ", fileInfo: " + fileInfo + ", progress: " + j16);
        }
        e6(i65, i65.msgId, l65, intValue, j16, fileInfo);
    }

    private final void t6(MsgRecord record) {
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
        MsgRecord i65 = i6(id5);
        if (i65 == null) {
            return;
        }
        com.tencent.qqnt.aio.adapter.richmedia.provider.h e16 = ru3.c.e(ru3.c.f432503a, i65, null, 2, null);
        this.downloadInfo.remove(j6(id5, subId));
        if (e16 != null) {
            e16.a(i65, subId, type, null);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService, com.tencent.mobileqq.activity.aio.photo.h
    public void D(int loadType) {
        if (this.f179747d == null) {
            return;
        }
        QLog.i("AIOImageProviderServiceNT", 1, "[loadMedias] + loadType: " + loadType);
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
                h6();
                return;
            }
            return;
        }
        h6();
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
        synchronized (this.msgRecordList) {
            this.msgRecordList.clear();
            Unit unit = Unit.INSTANCE;
        }
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
        MsgRecord i65 = i6(id5);
        if (i65 == null || (m56 = m5(id5)) == null || (S5 = S5("saveToWeiyun_MessageForPic")) == null) {
            return;
        }
        com.tencent.qqnt.aio.adapter.richmedia.provider.h e16 = ru3.c.e(ru3.c.f432503a, i65, null, 2, null);
        if (e16 != null) {
            QQAppInterface qqAppInterface = x5();
            Intrinsics.checkNotNullExpressionValue(qqAppInterface, "qqAppInterface");
            z16 = e16.d(m56, i65, S5, qqAppInterface);
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        super.f(id5);
    }

    public final void m6() {
        final long currentTimeMillis = System.currentTimeMillis();
        ArrayList<MsgTypeFilter> arrayList = new ArrayList<>();
        arrayList.add(new MsgTypeFilter(2, new ArrayList()));
        arrayList.add(new MsgTypeFilter(7, new ArrayList()));
        arrayList.add(new MsgTypeFilter(3, new ArrayList()));
        arrayList.add(new MsgTypeFilter(2, new ArrayList()));
        arrayList.add(new MsgTypeFilter(31, new ArrayList()));
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgsByTypeFilters(this.contact, this.minMsgId, 60, true, arrayList, new IMsgOperateCallback() { // from class: ru3.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList2) {
                b.n6(b.this, currentTimeMillis, i3, str, arrayList2);
            }
        });
    }

    public final boolean r6() {
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
            QLog.d("AIOImageProviderServiceNT", 2, "[preCheckLoadMedias] result: " + z17);
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService, com.tencent.mobileqq.activity.aio.photo.h
    public Intent u(long id5, int subId, int curType) {
        com.tencent.qqnt.aio.adapter.richmedia.provider.h e16;
        MsgRecord i65 = i6(id5);
        if (i65 == null || (e16 = ru3.c.e(ru3.c.f432503a, i65, null, 2, null)) == null) {
            return null;
        }
        return e16.h(i65, subId, null, curType);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService, com.tencent.mobileqq.activity.aio.photo.h
    public void y(long id5, int subId, int type) {
        MsgRecord i65 = i6(id5);
        if (i65 == null) {
            QLog.i("AIOImageProviderServiceNT", 1, "downloadMedia but id is not match, id: " + id5);
            return;
        }
        com.tencent.qqnt.aio.adapter.richmedia.provider.h e16 = ru3.c.e(ru3.c.f432503a, i65, null, 2, null);
        C11163b c11163b = new C11163b(i65, type, this, id5, subId);
        this.downloadInfo.put(j6(id5, subId), Integer.valueOf(type));
        QLog.i("AIOImageProviderServiceNT", 1, "[downloadMedia] msgSeq: " + i65.msgSeq + ", type: " + type + ", msgId: " + i65.msgId + ", subId: " + subId);
        if (e16 != null) {
            e16.g(i65, subId, type, null, c11163b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"ru3/b$c", "Lcom/tencent/qqnt/msg/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "onRichMediaProgerssUpdate", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c extends com.tencent.qqnt.msg.i {
        c() {
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(FileTransNotifyInfo notifyInfo) {
            if (notifyInfo != null) {
                b.this.o6(notifyInfo);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaProgerssUpdate(FileTransNotifyInfo notifyInfo) {
            if (notifyInfo != null) {
                b.this.p6(notifyInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d6(MsgRecord msg2, long id5, int subId, int type, int result, String resultStr, boolean isPart) {
        com.tencent.qqnt.aio.adapter.richmedia.provider.h e16 = ru3.c.e(ru3.c.f432503a, msg2, null, 2, null);
        notifyImageResult(id5, subId, e16 != null ? e16.f(msg2, type, true) : type, result, resultStr, isPart);
    }

    private final void e6(MsgRecord msg2, long id5, int subId, int type, long progress, FileTransNotifyInfo fileInfo) {
        com.tencent.qqnt.aio.adapter.richmedia.provider.h e16 = ru3.c.e(ru3.c.f432503a, msg2, null, 2, null);
        notifyImageProgress(msg2.msgId, subId, e16 != null ? e16.f(msg2, type, false) : type, (int) progress, fileInfo.totalSize, true);
    }

    public final void h6() {
        this.H = true;
        if (!r6()) {
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
        m6();
    }

    private final void s6(List<MsgRecord> msgList) {
        if (msgList != null) {
            for (MsgRecord msgRecord : msgList) {
                long j3 = this.minMsgSeq;
                long j16 = msgRecord.msgSeq;
                if (j3 > j16) {
                    this.minMsgSeq = j16;
                    this.minMsgId = msgRecord.msgId;
                }
            }
            QLog.i("AIOImageProviderServiceNT", 1, "updateMinId new minMsgId: " + this.minMsgId + ", new minSeq: " + this.minMsgSeq + ", msgListSize: " + msgList.size());
        }
    }

    private final void q6(List<MsgRecord> localMsgRecordList) {
        try {
            try {
                if (localMsgRecordList != null) {
                    this.M = localMsgRecordList.size();
                    List<AIORichMediaData> g65 = g6(localMsgRecordList);
                    List<ChatMessage> f65 = f6(localMsgRecordList);
                    if (!g65.isEmpty()) {
                        synchronized (this.msgRecordList) {
                            this.msgRecordList.addAll(0, localMsgRecordList);
                        }
                        List<AIORichMediaData> dataList = this.F;
                        Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
                        synchronized (dataList) {
                            this.F.addAll(0, g65);
                        }
                        List<ChatMessage> messageList = this.E;
                        Intrinsics.checkNotNullExpressionValue(messageList, "messageList");
                        synchronized (messageList) {
                            this.E.addAll(0, f65);
                        }
                        E3(g65);
                    }
                    QLog.i("AIOImageProviderServiceNT", 1, "[onMediaLoaded], msgRecordList.size: " + this.msgRecordList.size() + ", dataList.size: " + this.F.size());
                } else {
                    QLog.i("AIOImageProviderServiceNT", 1, "[onMediaLoaded], msgRecordList is null!");
                    M5();
                }
            } catch (Exception e16) {
                QLog.i("AIOImageProviderServiceNT", 1, "realLoadMedias exception = " + e16.getMessage());
            }
        } finally {
            this.H = false;
        }
    }
}
