package al.gov.asp.smc.e4.linkapp.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import al.gov.asp.smc.e4.linkapp.model.outer.IPublic;
import al.gov.asp.smc.e4.linkapp.model.outer.Person;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ViewPart {
	
	public static final String ID = "al.gov.asp.smc.e4.linkapp.views.ViewPart"; //$NON-NLS-1$
	private Table table;
	@Inject IPublic iPulic;
	@Inject
	private Composite parent;
	private TableViewer tableViewer;
	
	private Person person;

	@Inject
	public ViewPart() {
	
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 * @wbp.parser.entryPoint
	 */
	@PostConstruct
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		tableViewer = new TableViewer(container, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setBounds(0, 0, 450, 236);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tableViewer.setContentProvider( new ArrayContentProvider());
//		tableViewer.setLabelProvider(new PersonLabelProvider());
		TableViewerColumn tvc1 = new TableViewerColumn(tableViewer, SWT.None);
		TableColumn tc1 = tvc1.getColumn();
		tc1.setText("Emri");
		tc1.setWidth(100);
		tvc1.setLabelProvider(new ColumnLabelProvider() {
			
			@Override
			public String getText(Object element) {
				return ((Person)element).getFirstName();
			}
			
		});
		
		TableViewerColumn tvc2 = new TableViewerColumn(tableViewer, SWT.None);
		TableColumn tc2 = tvc2.getColumn();
		tc2.setText("Mbiemri");
		tc2.setWidth(100);
		tvc2.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				return ((Person)element).getLastName();
			}
		});
		
		TableViewerColumn tvc3 = new TableViewerColumn(tableViewer, SWT.None);
		TableColumn tc3 = tvc3.getColumn();
		tc3.setText("Gjendja Civile");
		tc3.setWidth(100);
		tvc3.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Person)element).isMarried()?"Martuar":"Beqar";
			}
			
		});
		
		TableViewerColumn tvc4 = new TableViewerColumn(tableViewer, SWT.None);
		TableColumn tc4 = tvc4.getColumn();
		tc4.setWidth(50);
		tc4.setText("Mosha");
		tvc4.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				// TODO Auto-generated method stub
				return String.valueOf(((Person)element).getAge());
			}
		});
		
		Button btnPastro = new Button(container, SWT.NONE);
		btnPastro.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				iPulic.clear();
				tableViewer.refresh();
			}
		});
		btnPastro.setBounds(179, 261, 91, 29);
		btnPastro.setText("Pastro");
		
		
		tableViewer.setInput(iPulic.getPersons());

	}
}
